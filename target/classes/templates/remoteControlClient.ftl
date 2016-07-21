<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="../stylesheet/bootstrap.css">
 <link rel="stylesheet" type="text/css" href="../guacamole.css"/>
</head>
<body>
<div class="container">
	<h2>${hostname}</h2>
	
	<div id="display"></div>

        
</div>
</body>
<script src="../javascripts/jquery-1.8.0.js"></script>
<script type="text/javascript" src="../javascripts/bootstrap.js"></script>
<!-- Guacamole JavaScript API -->
        <script type="text/javascript"
            src="../guacamole-common-js/all.min.js"></script>

        <!-- Init -->
        <script type="text/javascript"> /* <![CDATA[ */

            // Get display div from document
            var display = document.getElementById("display");

            // Instantiate client, using an HTTP tunnel for communications.
            var guac = new Guacamole.Client(
                new Guacamole.HTTPTunnel("/tunnel")
            );

            // Add client to display div
            display.appendChild(guac.getDisplay().getElement());
            
            // Error handler
            guac.onerror = function(error) {
                alert(error);
            };
			var data = "hostname=${hostname}&protocol=${protocol}&port=${port}&password=${password}"
            // Connect
            guac.connect(data);

            // Disconnect on close
            window.onunload = function() {
                guac.disconnect();
            }

            // Mouse
            var mouse = new Guacamole.Mouse(guac.getDisplay().getElement());

            mouse.onmousedown = 
            mouse.onmouseup   =
            mouse.onmousemove = function(mouseState) {
                guac.sendMouseState(mouseState);
            };

            // Keyboard
            var keyboard = new Guacamole.Keyboard(document);

            keyboard.onkeydown = function (keysym) {
                guac.sendKeyEvent(1, keysym);
            };

            keyboard.onkeyup = function (keysym) {
                guac.sendKeyEvent(0, keysym);
            };

        /* ]]> */ </script>
</html>