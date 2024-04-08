<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome to Building System</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    
</style>
</head>
<body>
<div class="container mt-5">
    <h2>Welcome to Building System</h2>
    <form action="AddProductServlet" method="post" class="mt-3">
        <div class="form-group">
            <label for="itemCode">Item Code:</label>
            <input type="text" class="form-control" id="itemCode" name="itemCode" required>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="text" class="form-control" id="quantity" name="quantity">
        </div>
        <button type="submit" class="btn btn-primary">Add Product</button>
    </form>
    <form action="PrintBillServlet" method="get" class="mt-3">
        <button type="submit" class="btn btn-success">Show Bill</button>
    </form>
</div>
</body>
</html>
