# java_dash
<br> Author name is Ananay saha <br>

Software Requirements Specification (SRS) Document

## 1. Introduction

1.1 Purpose

The purpose of this document is to provide a detailed description of the requirements for the development of an Author Page, outlining the functionalities and features it should possess.

1.2 Scope

The Author Page will include features such as user authentication (login and forget password), a home page with sections like About Us, Reviews (Add, Edit, Delete), Uploads (PDF and Image), Contact Us, and Check Messages. The primary focus is to create a platform for authors to showcase their work and receive feedback.

2. System Overview

The Author Page will be a web-based platform that allows authors to manage their profiles, showcase their work, and interact with readers.

3. Functional Requirements

3.1 User Authentication

<b>Login<b>

Users should be able to log in with valid credentials.
Unauthorized access should be restricted.

Forget Password
Users should have the option to reset their password through a secure process.

3.2 Home Page
About Us
Display information about the platform and its purpose.

Review
Allow authors to manage reviews for their work.
Add Review: Authors can receive feedback on their work.
Edit Review: Authors can make changes to existing reviews.
Delete Review: Authors can remove unwanted or inappropriate reviews.
Uploads

Authors can share their work through two types of uploads.
Upload PDF: Authors can upload their written work in PDF format.
Upload Image: Authors can upload cover images or illustrations related to their work.
Contact Us

Provide a contact form for users to send messages or inquiries.
Check Messages

Allow authors to view and respond to messages from readers.
Include a feature where reviewed documents can be uploaded for further discussion.
3.3 About Us

Display detailed information about the author, including bio, achievements, and contact information.
4. Non-Functional Requirements

4.1 Performance

The system should respond to user interactions within 2 seconds.
The platform should handle concurrent user logins without performance degradation.
4.2 Security

User passwords should be securely stored using encryption.
Access to the admin panel and critical functions should be restricted based on user roles.
4.3 User Interface

The user interface should be intuitive, with clear navigation and responsive design for various devices.
4.4 Scalability

The system should be able to handle an increasing number of users and uploaded documents.
5. Constraints

The system will be developed using HTML5, CSS3, JavaScript, and a backend framework (e.g., Django, Ruby on Rails).
6. Assumptions and Dependencies

The platform assumes a stable internet connection for users.
Dependencies include external libraries for secure authentication and file handling.
