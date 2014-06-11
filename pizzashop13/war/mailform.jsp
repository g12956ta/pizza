<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>メール送信</title>
    </head>
    <body>
        <h1>確認メールを送信します。</h1>
        自分のメールアアカウントのアドレスとパスワードを入力してください。
        確認メールのいらない方は下のしないボタンを押してください。
        <form action="/mail" method="get">
            <table>
                <tr><td>アドレス</td><td><input type="text" name="to"></td></tr>
                <tr><td>パスワード</td><td><input type="password" name="password"></td></tr>
                <tr><td colspan="2"><input type="submit" value="送信"></td></tr>
            </table>
        </form>
        <br><br>
   <input type="button" onclick="location.href='index.html'" value="送信しない">
    </body>
</html>