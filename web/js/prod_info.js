var addNum = function()
{
	var num = document.getElementById("buyNumInp");
	var intNum = num.value *=1;
	intNum+=1;
	num.value = intNum.toString();
};
var delNum = function()
{
	var num = document.getElementById("buyNumInp");
	var intNum = num.value *=1;
	if(intNum<=0)
		return;
	intNum-=1;
	num.value = intNum.toString();
};