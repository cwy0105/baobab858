function page_user() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'https://www.baobab858.com/jsp/admin/user.api';
	form.method = 'post';

	param.push([ 'div_code', '%%' ]);
	param.push([ 'push', '%%' ]);
	param.push([ 'date', '' ]);
	param.push([ 'user_email', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_cp() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'https://www.baobab858.com/jsp/admin/cp.api';
	form.method = 'post';

	param.push([ 'searchWord', '' ]);
	param.push([ 'kind', '%%' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_notice() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'https://www.baobab858.com/jsp/admin/noticeList.api';
	form.method = 'post';

	param.push([ 'read_div', '' ]);
	param.push([ 'searchWord', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_push() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'https://www.baobab858.com/jsp/admin/pushList.api';
	form.method = 'post';

	param.push([ 'push_div', '' ]);
	param.push([ 'searchWord', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_cpPush() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'https://www.baobab858.com/jsp/admin/cpPushList.api';
	form.method = 'post';

	param.push([ 'searchWord', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_review() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'https://www.baobab858.com/jsp/admin/reviewList.api';
	form.method = 'post';

	param.push([ 'cp_div', '' ]);
	param.push([ 'searchWord', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_search() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'https://www.baobab858.com/jsp/admin/searchWord.api';
	form.method = 'post';

	document.body.appendChild(form);
	form.submit();
}

function page_logHistory() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'https://www.baobab858.com/jsp/admin/loginHistory.api';
	form.method = 'post';

	param.push([ 'user_div', '' ]);
	param.push([ 'log_div','' ])
	param.push([ 'searchWord', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function page_visitant() {
	var form = document.createElement('form');
	var param = new Array();
	var input = new Array();

	form.action = 'https://www.baobab858.com/jsp/admin/visitant.api';
	form.method = 'post';

	param.push([ 'visitDiv', '누적' ]);
	param.push([ 'divCode','' ])
	param.push([ 'searchWord', '' ]);
	param.push([ 'visitNum', '' ]);
	param.push([ 'startDate', '' ]);
	param.push([ 'endDate', '' ]);

	for (var i = 0; i < param.length; i++) {
		input[i] = document.createElement('input');
		input[i].setAttribute('type', 'hidden');
		input[i].setAttribute('name', param[i][0]);
		input[i].setAttribute('value', param[i][1]);
		form.appendChild(input[i]);
	}
	document.body.appendChild(form);
	form.submit();
}

function version() {
	window
			.open('https://www.baobab858.com/jsp/admin/version.api', '버전',
					'width=500px, height=600px, toolbars=no, scrollbars=no, top=150px, left=600px');
}

function hitsUp() {
	if (confirm('정말로 초기화 하시겠습니다까?') == true) {
		window.location.href = "https://www.baobab858.com/jsp/admin/hitsUpdate.api";
	} else {
		alert('취소');
	}
}

function addrConversion(){
	window
	.open('https://www.baobab858.com/jsp/admin/addrConversion.api', '버전',
			'width=500px, height=600px, toolbars=no, scrollbars=no, top=150px, left=600px');
}

function checkServer(){
	window.open('https://www.baobab858.com/jsp/admin/checkServer.api', '점검',
			'width=500px, height=600px, toolbars=no, scrollbars=no, top=150px, left=600px');
}

function couponList() {
	var form = document.createElement('form');

	form.action = 'https://www.baobab858.com/jsp/admin/couponList.api';
	form.method = 'post';

	document.body.appendChild(form);
	form.submit();

}