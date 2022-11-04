/**
 * 
 */
document.addEventListener('DOMContentLoaded', function () {

	//저장버튼
	document.querySelector('#add').addEventListener('click', function () {
		let code = document.getElementById('id').value;
		let name = document.getElementById('name').value;
		let author = document.getElementById('writer').value;
		let press = document.getElementById('press').value;
		let price = document.getElementById('price').value;
		let data = 'bookCode=' + code + '&bookName=' + name + '&author=' + author + '&press=' + press + '&price=' + price;

		fetch('./BookAddServlet', {
				method: 'post',
				headers: {
					'Content-type': 'application/x-www-form-urlencoded'
				},
				body: data

			})
			.then(result => result.json())
			.then(addCallback)
			.catch(err => {
				console.log(err);
			});

		function addCallback(result) {
			document.querySelector('tbody').append(makeTr(result));

			//화면 입력 초기화
			document.querySelector('#id').value = '';
			document.querySelector('#name').value = '';
			document.querySelector('#writer').value = '';
			document.querySelector('#press').value = '';
			document.querySelector('#price').value = '';

		}
	});

	//선택 삭제버튼
	document.querySelector('#checked').addEventListener('click', function () {
	}
	//thead
	let tr = document.createElement('tr');
	//thead에 checkbox생성.
	let td = document.createElement('th');
	let checkbox = document.createElement('input');
	checkbox.setAttribute('type', 'checkbox');
	checkbox.addEventListener('change', function () {
		let cks = document.querySelectorAll('#show input[type="checkbox"]');
		cks.forEach(function (check) {
			check.checked = checkbox.checked;
		});
	})
	td.appendChild(checkbox);
	tr.appendChild(td);

	//thead title
	let titles = ['도서코드', '도서명', '저자', '출판사', '가격', '삭제'];
	for (let title of titles) {
		let idTag = document.createElement('th');
		let idTxt = document.createTextNode(title); // <th>아이디</th>
		idTag.appendChild(idTxt);
		tr.appendChild(idTag);
	}
	document.querySelector('thead').append(tr);


	fetch('./BookListServlet')
		.then(result => result.json())
		.then(bookList)
		.catch(err => console.log(err));

	function bookList(result = {}) {
		for (let bList of result) {
			let tr = makeTr(bList);
			document.querySelector('tbody').appendChild(tr);
		}
	}

	function makeTr(row) {
		let fields = ['bookCode', 'bookName', 'author', 'press', 'price']
		let tr = document.createElement('tr');
		//체크박스
		let td = document.createElement('td');
		let checkbox = document.createElement('input');
		checkbox.setAttribute('type', 'checkbox');
		tr.appendChild(checkbox);

		for (let field of fields) {
			let td = document.createElement('td');
			let txt = document.createTextNode(row[field]);
			td.appendChild(txt);
			tr.appendChild(td);
		}
		//삭제버튼
		let btn = document.createElement('button');
		btn.addEventListener('click', function () {
			this.parentElement.remove();
			let code = this.parentElement.querySelector('td').textContent;
			console.log(code);
			let data = 'bookCode=' + code;
			fetch('./BookDelServlet', {
					method: 'post',
					headers: {
						'Content-type': 'application/x-www-form-urlencoded'
					},
					body: data
				})
				.then(result => result.json())

				.catch(err => {
					console.log(err);
				});

		
		});
		let txt = document.createTextNode('삭제');
		btn.appendChild(txt);
		tr.appendChild(btn);
		return tr;
	}
});