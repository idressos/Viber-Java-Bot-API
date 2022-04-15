# Viber Java Bot API :robot:
A complete Java wrapper for the [Viber Bot REST API](https://developers.viber.com/).

## Project Goals
* Provide as accurate and thorough of an adaptation of the REST API as possible.
	* All events and message types are supported.
* Stay up to date with the latest release (currently [7.3.0](https://developers.viber.com/releases/#v7.3.0)).
* Make building a Viber bot easy.
	* Multiple message constructors for each type.
	* ButtonBuilder class to simplify RichMedia and Keyboard construction.
* Allow multiple webhooks to be registered simultaneously.
* Replace the official deprecated [Viber Java Bot API](https://github.com/Viber/viber-bot-java).

## Build Instructions
1. Download and install [Apache Maven](https://maven.apache.org/).
2. Compile and install to your local Maven repository:
	```shell
	$ git clone https://github.com/idressos/viber-java-bot-api.git
	$ cd viber-java-bot-api
	$ mvn clean install
	```
3. (Optional) Add as a dependency to your local Maven project's pom.xml:
	```xml
	<dependency>
	  <groupId>me.idressos</groupId>
	  <artifactId>viber-java-bot-api</artifactId>
	  <version>1.0</version>
	</dependency>
	```

## Usage
It is really important that you read through the [official documentation](https://developers.viber.com/docs/api/rest-bot-api/) as it will give you insight on how to make proper use of this library.  
In case of any issues refer to the official documentation before opening a ticket.

You will need a bot account with an authentication token. Create one in the [Viber Admin Panel](https://partners.viber.com/login) if you haven\'t already.

Viber communicates with your bot using **callbacks** in case of the following events:
```java
public static enum Event {
  WEBHOOK, SUBSCRIBED, UNSUBSCRIBED, CONVERSATION_STARTED, DELIVERED, SEEN, FAILED, MESSAGE
}
```
Callbacks are HTTP POST requests made to your bot's **callback URL** by Viber.  
Obviously, your program will need to include an HTTP server that listens for those callbacks in some context.  

Here is an example implementing the [com.sun.net.httpserver](https://docs.oracle.com/javase/8/docs/jre/api/net/httpserver/spec/com/sun/net/httpserver/package-summary.html) package:
```java
public static void start() {
  HttpServer server = HttpServer.create(  
    new InetSocketAddress(InetAddress.getByName("server-address"), 80, 0);
  server.createContext("/", new RequestHandler());
  
  server.start();
}

private static class RequestHandler implements HttpHandler {
  public void handle(HttpExchange exc) {
    if(exc.getRequestURI().getPath().equals("/")) {
      if(exc.getRequestHeaders().containsKey("X-Viber-Content-Signature")) {
        if(!exc.getRequestHeaders().get("X-Viber-Content-Signature").isEmpty()) {
          byte[] viberContentSignature = Utils.hexStringToByteArray(  
            exc.getRequestHeaders().get("X-Viber-Content-Signature").get(0));
		  
          String requestBody = null;
          try(Scanner s = new Scanner(exc.getRequestBody(), StandardCharsets.UTF_8).useDelimiter("\\A")) {
            if(s.hasNext()) requestBody = s.next();
          }
          
          if(requestBody != null) {
            byte[] hmacSHA256Hash = Utils.calculateHmacSHA256(  
              WebhookManager.getAuthToken().getBytes(), requestBody.getBytes(StandardCharsets.UTF_8));
			
            if(Arrays.equals(viberContentSignature, hmacSHA256Hash)) {
              // Content signature checks out, callback is authentic
              CallbackHandler.handle(new Callback(new JSONObject(requestBody)));
            }
          }
        }
      }
    }
  }
}
```

### Important Notes
* **SSL (HTTPS) is required** by Viber for webhooks. Self-signed certificates are not supported either.
    * In case you want to use an HTTP-only server package like com.sun.net.httpserver, you can reverse-proxy it locally with another web server (Apache, nginx) that has Cloudflare SSL.
* The above example is oversimplified in a couple of ways:
    * It is single-threaded. You should almost always prefer a **multi-threaded** solution, considering the fact your web server could be receiving multiple callbacks at a time.
	* No checks concerning the HTTP request method are being performed. It could be an unimplemented method, such as PUT. We only care about **GET, POST**.
	* Your web server could respond back to the callback. For example, make `CallbackHandler.handle()` return a response body for the exchange. This can be used for [sending a welcoming message](https://developers.viber.com/docs/api/rest-bot-api/#sending-a-welcome-message).
* The following methods are not included:
	* `Utils.hexStringToByteArray()` - self-explaining
	* `Utils.calculateHmacSHA256()` - used for calculating the HMAC SHA256 hash of a byte array
	* `CallbackHandler.handle()` - used for handling authentic incoming callbacks
* Each callback contains a **content signature** in the request headers. It is used to verify the callback's integrity
	* The signature is **HMAC with SHA256** that uses the bot account's authentication token as the key and the request JSON as the value.
* You must register your webhook in order to receive callbacks!
	* However, you don\'t need to register your webhook to perform most actions.

Registering your webhook:
```java
Webhook webhook = new Webhook("callback-url", "auth-token");
HTTPResponse httpResponse = webhook.set();

if(httpResponse.getCode() == 200) {
  ViberResponse viberResponse = new ViberResponse(new JSONObject(httpResponse.getBody()));
  
  if(viberResponse.getStatus() == 0) {
    // Webhook registration successful
  }
}
```

Handling a simple incoming callback:
```java
private String authToken = "auth-token";
private Sender sender = new Sender("sender-name");

public static void handle(Callback callback) throws IOException {
  if(callback.getEvent() == Event.MESSAGE) {
    if(callback.getMessage().getType() == MessageType.TEXT) {
      if(callback.getMessage().getText().equalsIgnoreCase("Ping")) {
        User user = callback.getSender(); // Never null in message callbacks
        
        Message response = new Message("Pong!");
        Actions.sendMessage(authToken, user.getId(), sender, response, null, 1);
      }
    }
  }
}
```

### Available Actions
| Method                                                                                              | Description                          |
| --------------------------------------------------------------------------------------------------- | ------------------------------------ |
| [Actions.sendMessage()](https://developers.viber.com/docs/api/rest-bot-api/#send-message)           | Send message to user                 |
| [Actions.broadcastMessage()](https://developers.viber.com/docs/api/rest-bot-api/#broadcast-message) | Broadcast message to a list of users |
| [Actions.getAccountInfo()](https://developers.viber.com/docs/api/rest-bot-api/#get-account-info)    | Get bot account information          |
| [Actions.getUserDetails()](https://developers.viber.com/docs/api/rest-bot-api/#get-user-details)    | Get details of a specific user       |
| [Actions.getOnline()](https://developers.viber.com/docs/api/rest-bot-api/#get-online)               | Get online status of a list of users |

### RichMedia and Keyboards
[RichMedia](https://developers.viber.com/docs/api/rest-bot-api/#rich-media-message--carousel-content-message) and [Keyboards](https://developers.viber.com/docs/api/rest-bot-api/#keyboards) can be frustrating to design because of buttons. [Buttons](https://developers.viber.com/docs/tools/keyboards/#buttons-parameters) have a very complex constructor due to their diverse nature.  
To ease the process, a ButtonBuilder class is included.

Building a simple button using ButtonBuilder:
```java
ButtonBuilder buttonBuilder = new ButtonBuilder();

buttonBuilder.setColumns(2); // Default: 6
buttonBuilder.setRows(2); // Default: 1
buttonBuilder.setText("Example Button");
buttonBuilder.setTextOpacity(50); // Default: 100
buttonBuilder.setActionType(ActionType.REPLY);
buttonBuilder.setActionBody("Hello, world!");
buttonBuilder.setBackgroundColor("#0080FF");

Button button = buttonBuilder.build();
```