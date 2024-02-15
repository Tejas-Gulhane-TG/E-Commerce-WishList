WishList Api{
POST :- Create a new wishlist.
        	localhost:8080/api/wishlists/create
        	{   
            	"wishListName":"First wishlist",
            	"username":9552776482,
            	"password":"Tejas@123"
         	}

GET  :- Get wishlist of user using WishList_Id, Username, Password
        	localhost:8080/api/wishlists/17054601/9552776482/Tejas@123

Delete :- Delete product from wishlist
  	    	localhost:8080/api/wishlists/product/delete
	   	{
		"productId":15928782,
		"wishListId":17682114,
		"username":9552776482,
		"password":"Tejas@123"
  	  	}

GET  :- Get all WishList of User.
        	localhost:8080/api/wishlists/allList
        	{   
            	"username":9552776482, 
            	"password":"Tejas@123"   
        	}
    
POST :- Add product in the WishList
    	localhost:8080/api/wishlists/addProduct
    		{   
            	"productId":15928782,
		"wishListId":6701976,
		"username":9552776482,
	        "password":"Tejas@123"
		}

DELETE :- Delete Wishlist 
    	localhost:8080/api/wishlists/delete
    		{
		"username":9552776482,
		"password":"Tejas@123",
		"wishListId":5548076
		}
}

User Api{

POST :- Add new User.
    	localhost:8080/user/create
    		{
        	"name":"Tejas",
        	"password":"Tejas@123",
        	"mobileNo":9552776482,
        	"emailId":"Tejas@gmail.com",
        	"address":"Yavatmal",
       		"age":25,
        	"gender":"MALE"
    		}
    
GET :- Get user By username and Password, Username is mobile no of user
    	localhost:8080/user/get
    		{
        	"userName":9552776482,
        	"password":"Tejas@123"
    		}
    
DELETE :- Delete user by Username and password
    	localhost:8080/user/delete
    		{ 
        	"userName":9552776482,
        	"password":"Tejas@123"
    		}
}

Product Api{

POST :- Added a new Product
    	localhost:8080/product/add
    		{
        	"productName":"HeadPhone",
        	"price":1999.00
    		}
    
GET :- Get a product by product_id
    	localhost:8080/product/get-by-productId/659840
    
DELETE :- delete product by product_id
    	localhost:8080/product/delete-by-id/659840
}
