describe("ShoppingCart", function() {
  var shoppingCart;
  
  beforeEach(function() {
	  shoppingCart = new ShoppingCart(200, 200);
  });
  
  describe("ShoppingCart with freight", function() {
	  it("should include the price of shipping", function(){
		  expect(shoppingCart.setTotal(50)).toEqual(250);
	  });
  });
  
  describe("ShoppingCart without freight", function() {
	  it("should remain the same price", function(){
		  expect(shoppingCart.setTotal()).toEqual(200);
	  });
  });
  
});
