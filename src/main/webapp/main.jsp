<%-- 
    Document   : index
    Created on : 12-Apr-2018, 15:16:26
    Author     : 
--%>

<!doctype html>
<html ng-app="myApp">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="js/main.js"></script>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
    <div ng-controller="myCtrl">
        <form ng-submit="sendPost()">
            Road Id : <input ng-model="id" />
            Application  Id : <input ng-model="appId"/>
            Application key : <input ng-model="appKey" />
            <button type="submit">Send</button>
        </form>
        <p>{{message}}
    </div>
</body>
</html>
