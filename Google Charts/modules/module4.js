
// Load the Visualization API and the corechart package
google.charts.load('current', { 'packages': ['corechart', 'table'] });

// Set a callback to run when the Google Visualization API is loaded
google.charts.setOnLoadCallback(retriveData);

function retriveData() {

    var URL = 'https://docs.google.com/spreadsheets/d/1SL8zq3X1PtzaHFrc7JYZwvOJiQFANf17ygG_fyNHN0I/gviz/tq?gid=0';
    var query = new google.visualization.Query(URL);

    var queryString = 'select A, B, C, D, E';
    query.setQuery(queryString);

    query.send(gotResponse);
}

function gotResponse(response) {

    var dataTable = response.getDataTable();

    var chart = new google.visualization.Table(document.getElementById('divChart'));
    chart.draw(dataTable, {});
}