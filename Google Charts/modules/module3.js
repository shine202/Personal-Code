
// Load the Visualization API and the corechart package
google.charts.load('current', { 'packages': ['corechart', 'table'] });

// Set a callback to run when the Google Visualization API is loaded
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

    var tooMuchData = [
        ['Data', 'Count', 'Misc String', 'Another'],
        [new Date(2016, 0, 1), 100, 'a string', 'another'],
        [new Date(2016, 5, 5), 200, 'more data', ''],
        [new Date(2016, 10, 11), 300, 'ignore this column', 'N/A'],
        [new Date(2017, 2, 5), 150, 'still more data', 'more here'],
        [new Date(2017, 6, 6), 210, 'a string', ''],
        [new Date(2017, 9, 20), 70, 'a string', '']
    ];

    var dataTable = google.visualization.arrayToDataTable(tooMuchData);

    var dataView = new google.visualization.DataView(dataTable);

    dataView.setColumns([0, 1, { calc: getNumDays, type: 'number', label: 'Num Days Elapsed' }]);

    var rowsWeNeed = dataTable.getFilteredRows([
        {
            column: 0,
            minValue: new Date(2017, 0, 1)
        }
    ]);
    dataView.setRows(rowsWeNeed);


    var chart = new google.visualization.Table(document.getElementById('divChart'));
    chart.draw(dataView, {});
}

function getNumDays(dataTable, rowIndex) {
    var cellValue = dataTable.getValue(rowIndex, 0);
    var baseDate = new Date(2017, 0, 1);

    return Math.abs(Math.round((baseDate - cellValue) / (1000 * 60 * 60 * 24)));
}