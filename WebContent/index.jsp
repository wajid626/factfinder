<%@ page session="false" %>
<html>
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Login</title>
        <!-- CSS -->
        <link rel="stylesheet" href="styles/reset.css">
        <link rel="stylesheet" href="styles/animate.css">
        <link rel="stylesheet" href="styles/styles.css">
</head>
<body>
        <div id="container">
                <form>
                <label for="name">Username:</label>
                <input type="name">
                <label for="username">Password:</label>
                <p><a href="#">Forgot your password?</a>
                <input type="password">
                <div id="lower">
                <input type="checkbox"><label class="check" for="checkbox">Keep me logged in</label>
                <input type="submit" value="Login">
                </div>
                </form>
        </div>
</body>
</html>
