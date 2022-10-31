document.addEventListener('DOMContentLoaded', domLoadedFunc);

function domLoadedFunc() {
	let data = `[{"id":1,"first_name":"Lou","last_name":"Catteroll","email":"lcatteroll0@topsy.com","gender":"Male","salary":8930},
				{"id":2,"first_name":"Liz","last_name":"Maven","email":"lmaven1@e-recht24.de","gender":"Female","salary":2145},
				{"id":3,"first_name":"Marion","last_name":"Sawney","email":"msawney2@qq.com","gender":"Male","salary":3978},
				{"id":4,"first_name":"Clemmie","last_name":"Vanni","email":"cvanni3@ft.com","gender":"Male","salary":3688}
				]`;
	let result = JSON.parse(data); //json => object
	/*	let obj = {}			
		console.log(result);
		
		console.log(result[1].email);
		for(let i=0;i<result.length;i++){
			console.log(`firstName: ${result[i].first_name}, lastName: ${result[i]['last_name']}`)
		}
		
		//확장 for
		for(let obj of result){
			console.log(`id: ${obj.id}, email: ${obj['email']}`);
		}
		console.clear();
		//배열이 경우에는 Array.forEach()
		result.forEach(function(value, index){
			if(index <2)
			console.log(value, index);
			
		});
	*/
	//확장 for.
	//table
	let table = document.createElement('table');
	table.setAttribute('border', 1);
	let show = document.getElementById('show');
	show.appendChild(table);

	//thead
	let thead = document.createElement('thead');
	let tr = document.createElement('tr');
	let titles = ['아이디', '이름', '이메일', '성별', '급여', '삭제'];
	for (let title of titles) {
		let idTag = document.createElement('th');
		let idTxt = document.createTextNode(title); // <th>아이디</th>
		idTag.appendChild(idTxt);
		tr.appendChild(idTag);
	}

	//thead에 checkbox생성.
	let td = document.createElement('th');
	let checkbox = document.createElement('input');
	checkbox.setAttribute('type', 'checkbox');
	checkbox.addEventListener('change', function() {
		let cks = document.querySelectorAll('#show input[type="checkbox"]');
		cks.forEach(function(check) {
			check.checked = checkbox.checked;
		});
	})
	td.appendChild(checkbox);
	tr.appendChild(td);

	thead.appendChild(tr);
	table.appendChild(thead);


	//tbody
	let tbody = document.createElement('tbody');
	table.appendChild(tbody);
	let fields = ['id', 'first_name', 'email', 'gender', 'salary'];

	//데이터 한건씩 <tr>출력
	for (let obj of result) {
		let tr = makeTr(obj);
		tbody.appendChild(tr);
	}//end of for(let obj of result)

	function makeTr(row) {
		// 데이터 건수 만큼 반복.
		let tr = document.createElement('tr');
		tr.addEventListener('click', showDetailFunc);
		tr.addEventListener('mouseout', function() {
			this.style.backgroundColor = null;
		});

		for (let field of fields) {
			// 항목만큼 반복.
			let td = document.createElement('td');
			let txt = document.createTextNode(row[field]);
			td.appendChild(txt);
			tr.appendChild(td);
		}
		//삭제버튼.<td><button>삭제</button></td>
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.addEventListener('click', function() {
			this.parentElement.parentElement.remove();
		});
		let txt = document.createTextNode('삭제');
		td.appendChild(btn);
		btn.appendChild(txt);
		tr.appendChild(td);

		//체크박스.<td><checkbox></checkbox></td>
		td = document.createElement('td');
		let checkBox = document.createElement('input');
		checkBox.setAttribute('type', 'checkbox');
		td.appendChild(checkBox);
		tr.appendChild(td);

		return tr;
	} // end of makeTr();


	//추가버튼에 이벤트 등록.
	document.querySelectorAll('button[type="button"]')[0].addEventListener('click', addFunc);
	//수정버튼에 이벤트등록
	document.querySelectorAll('button[type="button"]')[1].addEventListener('click', updateFunc);
	//선택삭제버튼에 이벤트 등록
	document.querySelectorAll('button[type="button"]')[2].addEventListener('click', deleteFunc);


	function addFunc() {
		let id = document.getElementById('id').value;
		let fn = document.getElementById('fname').value;
		let em = document.getElementById('email').value;
		let sa = document.getElementById('salary').value;
		let gn = document.getElementById('gender').value;
		let check = id && fn && em && sa && gn;
		if (!check) {
			alert('입력항목확인')
			return;
		}
		let newRow = {
			id: id,
			first_name: fn,
			email: em,
			salary: sa,
			gender: gn
		}
		document.querySelector('#show>table>tbody').appendChild(makeTr(newRow));
	}


	function updateFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		for (let i = 0; i < trs.length; i++) {
			if (document.getElementById('id').value == trs[i].children[0].textContent) {
				trs[i].children[0].textContent = document.getElementById('id').value;
				trs[i].children[1].textContent = document.getElementById('fname').value;
				trs[i].children[2].textContent = document.getElementById('email').value;
				trs[i].children[3].textContent = document.getElementById('gender').value;
				trs[i].children[4].textContent = document.getElementById('salary').value;
			}
		}
	}


	function deleteFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		for (let i = 0; i < trs.length; i++) {
			if (trs[i].children[6].children[0].checked == true) {
				trs[i].remove();
			}
		}

	}

	//데이터 클릭시 색 변경 및 상세정보 출력
	function showDetailFunc() {
		this.style.backgroundColor = 'yellow';
		document.getElementById('id').value = this.children[0].textContent;
		document.getElementById('fname').value = this.children[1].textContent;
		document.getElementById('email').value = this.children[2].textContent;
		document.getElementById('gender').value = this.children[3].textContent;
		document.getElementById('salary').value = this.children[4].textContent;
		// console.log(this.children[1].textContent);
	}
}// end of domLoadedFunc()