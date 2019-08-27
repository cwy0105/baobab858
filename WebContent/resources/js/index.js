var duration = 2000;
		var index1 = 0;
		var index2 = 0;
		var index3 = 0;
		var index4 = 0;
		window.onload = function() {
			slideShow1();
			slideShow2();
			slideShow3();
			slideShow4();
		}
		function slideShow1() {
			var i;
			var x = document.getElementsByClassName('slide_img1');
			for(i=0;i<x.length;i++){
				x[i].style.display = "none";
			}
			index1++;
			if(index1 > x.length){
				index1 = 1;
			}
			x[index1-1].style.display = "block";
			setTimeout(slideShow1, duration);
		}
		function slideShow2() {
			var i;
			var x = document.getElementsByClassName('slide_img2');
			for(i=0;i<x.length;i++){
				x[i].style.display = "none";
			}
			index2++;
			if(index2 > x.length){
				index2 = 1;
			}
			x[index2-1].style.display = "block";
			setTimeout(slideShow2, duration);
		}
		function slideShow3() {
			var i;
			var x = document.getElementsByClassName('slide_img3');
			for(i=0;i<x.length;i++){
				x[i].style.display = "none";
			}
			index3++;
			if(index3 > x.length){
				index3 = 1;
			}
			x[index3-1].style.display = "block";
			setTimeout(slideShow3, duration);
		}
		function slideShow4() {
			var i;
			var x = document.getElementsByClassName('slide_img4');
			for(i=0;i<x.length;i++){
				x[i].style.display = "none";
			}
			index4++;
			if(index4 > x.length){
				index4 = 1;
			}
			x[index4-1].style.display = "block";
			setTimeout(slideShow4, duration);
		}