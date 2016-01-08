<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
<link rel = "stylesheet" 
         href = "//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
			
      <script src = "//code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "/resources/demos/external/jquery-mousewheel/jquery.mousewheel.js"></script>
      <script src = "//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script type="text/javascript">

(function($,W,D)
		{
		    var JQUERY4U = {};

		    JQUERY4U.UTIL =
		    {
		        setupFormValidation: function()
		        {
		            //form validation rules
		            $("#register-form").validate({
		                rules: {
		                    firstname: "required",
		                    lastname: "required",
		                    email: {
		                        required: true,
		                        email: true
		                    },
		                    password: {
		                        required: true,
		                        minlength: 5
		                    },
		                    agree: "required"
		                },
		                messages: {
		                    firstname: "Please enter your firstname",
		                    lastname: "Please enter your lastname",
		                    password: {
		                        required: "Please provide a password",
		                        minlength: "Your password must be at least 5 characters long"
		                    },
		                    email: "Please enter a valid email address",
		                    agree: "Please accept our policy"
		                },
		                submitHandler: function(form) {
		                    form.submit();
		                }
		            });
		        }
		    }

		    //when the dom has loaded setup form validation rules
		    $(D).ready(function($) {
		        JQUERY4U.UTIL.setupFormValidation();
		    });

		})(jQuery, window, document);
</script>
</head>
<body>
 


<a href="hello.html">click</a>  
<form action="" method="post" id="register-form" novalidate="novalidate">

    <h2>User Registration</h2>

    <div id="form-content">
  
        <fieldset>

            <div class="fieldgroup">
                <label for="firstname">First Name</label>
                <input type="text" name="firstname"/>
            </div>

            <div class="fieldgroup">
                <label for="lastname">Last Name</label>
                <input type="text" name="lastname"/>
            </div>

            <div class="fieldgroup">
                <label for="email">Email</label>
                <input type="text" name="email"/>
            </div>

            <div class="fieldgroup">
                <label for="password">Password</label>
                <input type="password" name="password"/>
            </div>

            <div class="fieldgroup">
                <p class="right">By clicking register you agree to our <a target="_blank" href="/policy">policy</a>.</p>
                <input type="submit" value="Register" class="submit"/>
            </div>

        </fieldset>
    </div>

        <div class="fieldgroup">
            <p>Already registered? <a href="/login">Sign in</a>.</p>
        </div>
</form>
</body>
</html>