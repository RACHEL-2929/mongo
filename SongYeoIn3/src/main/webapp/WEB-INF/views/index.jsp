<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
      <title>Spring Boot WebSocket Chat Application</title>
      <link rel="stylesheet" href="/css/main.css" />
  </head>
  <body>
    <noscript>
      <h2>Sorry! Your browser doesn't support Javascript</h2>
    </noscript>

    <div id="username-page">
        <div class="username-page-container">
            <h1 class="title">Type your username</h1>
            <form id="usernameForm" name="usernameForm">
                <div class="form-group">
                    <input type="text" id="name" placeholder="Username" autocomplete="off" class="form-control" />
                </div>
                <div class="form-group">
                    <button type="submit" class="accent username-submit">Start Chatting</button>
                </div>
            </form>
        </div>
    </div>

    <div id="chat-page" class="hidden">
        <div class="chat-container">
            <div class="chat-header">
                <h2>Spring WebSocket Chat Demo</h2>
            </div>
            <div class="connecting">
                Connecting...
            </div>
            <ul id="messageArea">

            </ul>
            <form id="messageForm" name="messageForm">
                <div class="form-group">
                    <div class="input-group clearfix">
                        <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                        <button type="submit" class="primary">Send</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="/js/main.js"></script>
  </body>
  
  <script type="text/javascript">
//WebSocket URL
  const socketUrl = 'ws://localhost:8080/chat';

  // Create a new WebSocket connection
  const socket = new WebSocket(socketUrl);

  // Use SockJS and STOMP
  const stompClient = Stomp.over(socket);

  stompClient.connect({}, function (frame) {
      console.log('Connected: ' + frame);

      // Subscribe to a topic
      stompClient.subscribe('/sub/chat/room/b87f4648-e7f6-4ec3-8b0c-84920eeb0f8a', function (messageOutput) {
          console.log('Received message: ' + messageOutput.body);
      });

      // Send a message
      stompClient.send("/pub/chat/message", {}, JSON.stringify({
          chatRoomNo: "b87f4648-e7f6-4ec3-8b0c-84920eeb0f8a",
          sender: "testUser",
          message: "Hello, WebSocket!"
      }));
  });

  
  </script>
</html>