<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<h1>File Upload example with Jersey</h1>
 
<form action="api/file/upload" 
	method="post" enctype="multipart/form-data">
	Select a file: <input type="file" name="file" size="50" />
    <br/><br/>
   <input type="submit" value="Upload" />
</form>
 
</body>
</html>