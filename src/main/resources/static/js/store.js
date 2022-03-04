// $.get('/store/', function (data) {
//     let out = document.getElementById("table_clients")
//
//     let table = "<table> <tr><th>id</th><th>Имя</th><th>Фамилия</th><th>Отчество</th><th>Номер телефона</th><th>Эл. почта</th><th>Паспорт</th><th>Лимит</th><th>Процентная ставка</th></tr>";
//
//     for (i = 0; i<data.length; i++){
//         table = table + "<tr><td>" + data[i].id_client +"</td>" +
//             "<td>" + data[i].name + "</td>" +
//             "<td>" + data[i].surname + "</td>" +
//             "<td>" + data[i].patronymic +"</td>" +
//             "<td>" + data[i].number + "</td>" +
//             "<td>" + data[i].email + "</td>" +
//             "<td>" + data[i].passport + "</td>" +
//             "<td>" + data[i].limit + "</td>" +
//             "<td>" + data[i].interest_rate + "</td>" +"</tr>";
//     }
//     table = table + "</table>";
//
//     out.innerHTML = table;
// })
//
// document.getElementById("content").style.display = "block"