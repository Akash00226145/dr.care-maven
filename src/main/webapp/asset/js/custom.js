/* Filename: custom.js */
$(document).ready(function(){
	
		$(".select-btn").click(function(){
			 window.location.href='adminlogin.jsp';
			//alert("This from custom document...");
			/*var value = $(this).attr("productid");
			var url = "details.html?id="+value;
			window.location.href= url;*/
		});

		$(".pat1-btn").click(function(){
			//alert("This from custom document...");
			 window.location.href='PatientLogin.jsp';
			
		});
		
		$(".ots-btn").click(function(){
			//alert("This from custom document...");
			 window.location.href='OtherStaffLogin.jsp';
			
		});
	
		$(".pha1-btn").click(function(){
			 window.location.href='PharmacistLogin.jsp';
			
		});
		
		$(".gp-btn").click(function(){
			 window.location.href='GPLogin.jsp';	
		});
});