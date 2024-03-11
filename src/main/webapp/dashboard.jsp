<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Your head content goes here -->
</head>
<body class="bodyClass">
    <div style="height: 90vh; display: flex; justify-content: center; align-items: center;">
        <div>
            <img src="<%=request.getContextPath()%>/resources/sidePic.png" alt="leftimage" height="480px" style="box-shadow: 0px 0px 8px 8px rgba(138, 136, 136, 0.678);">
        </div>
        <div style="box-shadow: 5px 0px 8px 8px rgba(138, 136, 136, 0.678); width: 400px; display: flex; flex-direction: column; background-color: aliceblue;">
            <!-- heading -->
            <div style="text-align: center">
                <h1 style="margin: 0px; background-color: #0796ce; padding: 20px 0px; color: white;">Sign in</h1>
            </div>
            <!-- form part -->
            <form action="loginservelet1" method="post">
                <div style="margin: 60px 20px 60px 30px">
                    <div style="margin-bottom: 20px">
                        <div style="margin-bottom: 5px">
                            <label for="email" style="font-size: 18px">Email</label>
                        </div>
                        <div>
                            <input type="email" name="email" placeholder="Email" style="width: 95%; height: 35px; font-size: 20px" id="emailField"/>
                        </div>
                    </div>
                    <div>
                        <div style="margin-bottom: 5px">
                            <label for="Password" style="font-size: 18px">Password</label>
                        </div>
                        <div>
                            <input type="password" name="password" placeholder="Password" style="width: 95%; height: 35px; font-size: 20px" id="passwordField"/>
                        </div>
                    </div>
                </div>
                <!-- button -->
                <div style="margin-top: 20px; margin-bottom: 30px;">
                    <div style="text-align: center">
                        <button type="submit" style="padding: 10px 40px; cursor: pointer; background-color: #0796ce; border: 0px; color: white; border-radius: 8px; font-size: 20px;">
                            Sign in
                        </button>
                    </div>
                    <div style="margin-top: 10px">
                        <div style="text-align: center">
                            Don't have any account? <a href="<%=request.getContextPath()%>/signUp.html">Sign Up</a>
                        </div>
                    </div>
                    <div style="margin-top: 10px">
                        <div style="text-align: center">
                            <a href="<%=request.getContextPath()%>/forgotpass.html">Forgot Password</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!-- script -->
    <script>
        // Your JavaScript code goes here
    </script>
</body>
</html>
