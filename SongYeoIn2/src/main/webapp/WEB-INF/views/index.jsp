<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.2/sockjs.min.js"></script>
</head>
<body>
<h1>STOMP WebSocket Example</h1>
    <div id="messages"></div>
<script type="text/javascript">
const socket = new SockJS('http://localhost:8080/chat');
const stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    
    stompClient.subscribe('/sub/chat/room/1', function (messageOutput) {
    	const messagesDiv = document.getElementById('messages');
        messagesDiv.innerHTML += '<p>' + messageOutput.body + '</p>';
    });

    stompClient.send("/pub/chat/message", {}, JSON.stringify({
        chatRoomNo: "1",
        sender: "testUser",
        message: "Hello, WebSocket!"
    }));
}, function (error) {
	console.log('STOMP error: ' + error);
});


</script>
</body>
</html>