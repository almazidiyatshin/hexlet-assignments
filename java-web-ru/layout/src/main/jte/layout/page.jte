@import gg.jte.Content

@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<nav>
    <a href="/">Main</a>
    <a href="/users">Users</a>
</nav>
${content}
<div>
    <p>Just string</p>
</div>
</body>
</html>