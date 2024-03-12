<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      .bodyClass {
        background: url("<%= request.getContextPath() %>/resources/bg.jpeg");
        background-repeat: no-repeat;
        background-position: center;
        background-size: cover;
      }
    </style>
  </head>
  <body class="bodyClass">
    <div
      style="
        height: 90vh;
        display: flex;
        justify-content: center;
        align-items: center;
      "
    >
      <div>
        <img
          src="<%= request.getContextPath() %>/resources/sidePic.png"
          alt="leftimage"
          height="640px"
          style="box-shadow: 0px 0px 8px 8px rgba(138, 136, 136, 0.678)"
        />
      </div>
      <div
        style="
          /* border: 1px solid rgb(204, 201, 201); */
          box-shadow: 5px 0px 8px 8px rgba(138, 136, 136, 0.678);
          /* height: 500px; */
          width: 500px;
          display: flex;
          flex-direction: column;
          background-color: aliceblue;
        "
      >
        <!-- heading -->
        <div style="text-align: center">
          <h1
            style="
              margin: 0px;
              background-color: #0796ce;
              padding: 20px 0px;
              color: white;
            "
          >
            Sign in
          </h1>
        </div>
        <!-- form part -->
        <form action="">
          <div style="margin: 30px 20px 30px 30px">
            <div style="margin-bottom: 20px">
              <div style="margin-bottom: 5px">
                <label for="name" style="font-size: 18px">Name</label>
              </div>
              <div>
                <input
                  type="text"
                  placeholder="Name"
                  style="width: 95%; height: 35px; font-size: 20px"
                  id="emailField"
                />
              </div>
            </div>
            <div style="margin-bottom: 20px">
              <div style="margin-bottom: 5px">
                <label for="organization" style="font-size: 18px"
                  >Organization</label
                >
              </div>
              <div>
                <input
                  type="text"
                  placeholder="Organization"
                  style="width: 95%; height: 35px; font-size: 20px"
                  id="emailField"
                />
              </div>
            </div>
            <div style="margin-bottom: 20px">
              <div style="margin-bottom: 5px">
                <label for="email" style="font-size: 18px">Email</label>
              </div>
              <div>
                <input
                  type="email"
                  placeholder="Email"
                  style="width: 95%; height: 35px; font-size: 20px"
                  id="emailField"
                />
              </div>
            </div>
            <div style="margin-bottom: 20px">
              <div style="margin-bottom: 5px">
                <label for="mobile_no" style="font-size: 18px"
                  >Mobile Number</label
                >
              </div>
              <div>
                <input
                  type="number"
                  placeholder="Mobile Number"
                  style="width: 95%; height: 35px; font-size: 20px"
                  id="emailField"
                />
              </div>
            </div>
            <div>
              <div style="margin-bottom: 5px">
                <label for="Password" style="font-size: 18px">Password</label>
              </div>
              <div>
                <input
                  type="password"
                  placeholder="Password"
                  style="width: 95%; height: 35px; font-size: 20px"
                  id="passwordField"
                />
              </div>
            </div>
          </div>
          <!-- button -->
          <div style="margin-top: 20px">
            <div style="text-align: center">
              <button
                style="
                  padding: 10px 40px;
                  cursor: pointer;
                  background-color: #0796ce;
                  border: 0px;
                  color: white;
                  border-radius: 8px;
                  font-size: 20px;
                "
                onclick="submitData(event)"
              >
                Sign Up
              </button>
            </div>
            <div style="margin-top: 10px; margin-bottom: 20px;">
              <div style="text-align: center">
                Already have an accountt? <a href="<%= request.getContextPath() %>/login.html">Sign In</a>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>

    <!-- script -->
    <script>
      const submitData = (e) => {
        let email = document.getElementById("emailField");
        console.log(email.value, "email");
        let password = document.getElementById("passwordField");
        console.log(password.value, "password");
      };
    </script>
  </body>
</html>
