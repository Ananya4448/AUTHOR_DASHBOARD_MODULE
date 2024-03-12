<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous"
    />
    <style>
        .buttonStyle {
            border: 0px;
            padding: 5px 7px;
            border-radius: 5px;
            color: white;
        }
        .updateBtn {
            background-color: #5fce9b;
        }
        .deleteBtn {
            background-color: #e87352;
        }
    </style>
</head>
<body style="margin: 0">
<div>

    <!-- header -->
    <div
        style="
          display: flex;
          flex-direction: row;
          justify-content: space-between;
          align-items: center;
          padding: 30px 80px;
          box-shadow: 0px 0px 8px 8px rgb(204, 201, 201);
          border: 1px solid rgb(204, 201, 201);
        "
    >
        <div>LOGO</div>
        <div style="display: flex">
            <div style="margin: 0px 15px 0px 0px">
                <img
                    src="<%=request.getContextPath()%>/resources/support.png"
                    height="35px"
                    width="35px"
                    style="cursor: pointer"
                />
            </div>
            <div style="margin: 0px 0px 0px 15px">
                <img
                    src="<%=request.getContextPath()%>/resources/setting.png"
                    width="30"
                    height="30"
                    style="cursor: pointer"
                />
            </div>
        </div>
    </div>
    <!-- content -->
    <div
        style="
          display: flex;
          justify-content: space-between;
          flex-wrap: wrap;
          padding: 30px 80px;
        "
    >
        <!-- left aside -->
        <div
            style="
            width: 20%;
            background-color: #2d3e4e;
            color: white;
            box-shadow: 0px 0px 8px 8px rgb(204, 201, 201);
          "
        >
            <!-- profil image card -->
            <div style="text-align: center; padding: 70px 0px">
                <img
                    src="<%=request.getContextPath()%>/resources/defaultProfile.jpg"
                    alt="profile picture"
                    width="120px"
                    style="border-radius: 50%"
                />
                <div style="margin-top: 10px; font-size: 22px">Ananya Saha</div>
                <div style="color: rgb(199, 192, 192)">Author</div>
            </div>
            <!-- options -->
            <div>
                <div
                    style="
                padding: 15px 50px;
                display: flex;
                justify-content: space-between;
                align-items: center;
                cursor: pointer;
                background-color: #263643;
              "
                >
                    <div style="display: flex">
                        <div>
                            <img
                                src="<%=request.getContextPath()%>/resources/dashboard.png"
                                width="25px"
                                height="25px"
                            />
                        </div>
                        <div style="padding-left: 30px">Dashboard</div>
                    </div>
                    <!-- opened arrow -->
                    <div>
                        <img
                            src="<%=request.getContextPath()%>/resources/enabledArrow.png"
                            width="30px"
                            height="30px"
                        />
                    </div>
                </div>
                <div
                    style="
                padding: 15px 50px;
                display: flex;
                justify-content: space-between;
                align-items: center;
                cursor: pointer;
              "
                >
                    <div style="display: flex">
                        <div>
                            <img
                                src="<%=request.getContextPath()%>/resources/editIcon.png"
                                height="25px"
                                width="25px"
                            />
                        </div>
                        <div style="padding-left: 30px">Edit Profile</div>
                    </div>
                </div>
                <div
                    style="
                padding: 15px 50px;
                display: flex;
                justify-content: space-between;
                align-items: center;
                cursor: pointer;
              "
                >
                    <div style="display: flex">
                        <div>
                            <img
                                src="<%=request.getContextPath()%>/resources/logOut.png"
                                height="25px"
                                width="25px"
                            />
                        </div>
                        <div style="padding-left: 30px">Log Out</div>
                    </div>
                </div>
            </div>
        </div>
        <!-- right side -->
        <div
            style="
            width: 78%;
            border: 1px solid rgb(204, 201, 201);
            box-shadow: 0px 0px 8px 8px rgb(204, 201, 201);
          "
        >
            <!-- 1st row -->
            <div
                style="
              display: flex;
              justify-content: space-between;
              align-items: center;
              padding: 20px;
              flex-wrap: wrap;
            "
            >
                <div
                    style="
                background-color: #5fce9b;
                padding: 40px;
                width: 300px;
                height: 300px;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                cursor: pointer;
              "
                >
                    <div>
                        <img
                            src="<%=request.getContextPath()%>/resources/addSubmission.png"
                            width="90px"
                        />
                    </div>
                    <div style="color: white; font-size: 25px">Add Submission</div>
                </div>
                <div
                    style="
                background-color: #66b5d6;
                padding: 40px;
                width: 300px;
                height: 300px;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                cursor: pointer;
              "
                >
                    <div>
                        <img
                            src="<%=request.getContextPath()%>/resources/statusIcon.png"
                            width="90px"
                        />
                    </div>
                    <div style="color: white; font-size: 25px">Status</div>
                </div>
                <div
                    style="
                background-color: #e87352;
                padding: 40px;
                width: 300px;
                height: 300px;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                cursor: pointer;
              "
                >
                    <div>
                        <img
                            src="<%=request.getContextPath()%>/resources/reviewsIcon.png"
                            width="90px"
                        />
                    </div>
                    <div style="color: white; font-size: 25px">Review Feedbacks</div>
                </div>
                <div
                    style="
                background-color: #eeca5a;
                padding: 40px;
                width: 300px;
                height: 300px;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                cursor: pointer;
              "
                >
                    <div>
                        <img
                            src="<%=request.getContextPath()%>/resources/inviteFriendsIcon.png"
                            width="90px"
                        />
                    </div>
                    <div style="color: white; font-size: 25px">Invite Friends</div>
                </div>
            </div>
            <!-- 2nd row -->
            <div
                style="
              padding: 10px 20px;
            "
            >
                <div style="border: 1px solid rgb(204, 201, 201)">
                    <h4
                        style="
                  margin: 0px;
                  padding: 10px;
                  background-color: #2d3e4e;
                  color: white;
                "
                    >
                        Your Submissions
                    </h4>
                    <div style="height: 40vh; overflow-y: auto; padding: 10px">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">Action</th>
                                <th scope="col">Title</th>
                                <th scope="col">Submitted On</th>
                                <th scope="col">Field</th>
                                <th scope="col">Abstract</th>
                                <th scope="col">Keywords</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                    <button class="buttonStyle updateBtn">Update</button>
                                    <button class="buttonStyle deleteBtn">Delete</button>
                                </td>
                                <td>Title 1</td>
                                <td>2024-03-23</td>
                                <td>Mathematics</td>
                                <td>Abstract 1</td>
                                <td>Keyword 1</td>
                            </tr>
                            <tr>
                                <td>
                                    <button class="buttonStyle updateBtn">Update</button>
                                    <button class="buttonStyle deleteBtn">Delete</button>
                                </td>
                                <td>Title 2</td>
                                <td>2024-03-23</td>
                                <td>Politics</td>
                                <td>Abstract 2</td>
                                <td>Keyword 2</td>
                            </tr>
                            <tr>
                                <td>
                                    <button class="buttonStyle updateBtn">Update</button>
                                    <button class="buttonStyle deleteBtn">Delete</button>
                                </td>
                                <td>Title 3</td>
                                <td>2024-03-23</td>
                                <td>Science</td>
                                <td>Abstract 3</td>
                                <td>Keyword 3</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"
></script>
</body>
</html>
