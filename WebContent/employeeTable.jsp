<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center;"> Welcome to employee table</h1>
	
	 <div class="row justify-content-center">
        <form action="CRUDServlet.java" method="POST" >
        <div class="form-group">
            <div>
                <h3>CRUD Form </h3>
               
            </div>
            <input  type="hidden" name="id" value="">
            <label for="name" class="name">Name</label><br>
            <input class="form-control" type="text" name="name" value=""><br>
        </div> 
        <div class="form-group">
            <label for="location" class="location">Location</label><br>
        
          
            <input class="form-control" type="text" name="location" value=""><br>
        </div>  
        <div class="form-group"> 
           
            <?php if($edit_state==false):?>
                <input type="submit" name="save" value="Save" class="btn btn-success">  </button>
                
            <?php else: ?>
                <input type="submit" name="update" value="Update" class="btn btn-primary"></button>
            <?php endif; ?>
        </div>
        </form>
        </div>
</body>
</html>