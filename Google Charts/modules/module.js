
// Load the Visualization API and the corechart package
google.charts.load('current', { 'packages': ['corechart'] });
google.charts.setOnLoadCallback(retriveData);

function retriveData() {

    var URL = 'https://docs.google.com/spreadsheets/d/1SL8zq3X1PtzaHFrc7JYZwvOJiQFANf17ygG_fyNHN0I/gviz/tq?gid=0';
    var query = 'SELECT A, B, C, D, E, F';
    getDataFromSheet(URL, query, handleOverallIncomeResponse);

}

function handleOverallIncomeResponse(response) {

    var data = response.getDataTable();

    data.addColumn({
        type: 'String',
        role: 'tooltip'
    });

    var numRows = data.getNumberOfRows();
    var numCols = data.getNumberOfColumns();
    var tooltipColumnIndex = numCols - 1;

    data.setColumnProperty(tooltipColumnIndex, 'html', true);
    view.setColumns([0, 4, tooltipColumnIndex]);

    var tooltipChart = new google.visualization.PieChart(document.getElementById('divTooltipChart'));

    for(var i = 0; i < numRows; i++) {

        var theDate = date.getValue(i, 0);
        var dateString = monthName(theDate.getMonth()) + ' ' + theDate.getFullYear();
        var standardBikeSales = data.getValue(i, 1);
        var electricBikeSales = data.getValue(i, 2);
        var accessoriesSales = data.getValue(i , 3);
        var topSalesRep = data.getValue(i, 5);

        var pieData = google.visualization.arrayToDataTable([
            ['Category', 'Amount'],
            ['Standard Bikes', standardBikeSales],
            ['Electric Bikes', electricBikeSales],
            ['Accessories', accessoriesSales]
        ]);

        var pieOptions = {
            title: 'Income By Category',
            height: 180,
            width: 240,
            legend: {
                position: 'right'
            },
            pieSliceText: 'none'
        };

        google.visualization.events.addListener(tooltipChart, 'ready', function() {

            var tooltipHtml =
            '<div style="border: 3px solid black; padding: 0px; ">' +
                '<img src="' + tooltipChart.getImageURI() + '">' +
                '<style>' +
                    '.tiptab { border: 1px solid black; border-collapse: collapse; }' +
                    '.td { font-family: Helvetica, Arial; font-size: 0.9em; padding: 5px;}' +
                '</style>' +
                '<div style="width: 200px; margin-top: 0; margin-left: auto; margin-right: auto; padding: 10px; padding-top: 0;">' +
                    '<span style="font-weight: bold;">' + dateString + ':</span><br/><br/>' +
                    '<table class="tiptab">' +
                    '<tr><td class="td"> Standard Bikes</td><td class="td"> $'+standardBikeSales.commaSeparated() + '</td></tr>' +
                    '<tr><td class="td"> Electric Bikes</td><td class="td"> $'+electricBikeSales.commaSeparated() + '</td></tr>' +
                    '<tr><td class="td"> Accessories</td><td class="td"> $'+accessoriesSales.commaSeparated() + '</td></tr>' +
                    '</table><br/>' +
                    '<b>Top Sales Rep:</b> '+ topSalesRep + '<br/>' +
                '</div>' +
            '</div>';
            data.setCell(i, tooltipColumnIndex, tooltipHtml);
        });

        tooltipChart.draw(pieData, pieOptions);

        var options = {
            title: 'Income',
            height: 500,
            legend: { position: 'top', maxLines: 3 },
            vAxis: {
                minValue: 0,
                format: 'currency'
            },
            chartArea: {
                left: '10%',
                width: '88%'
            },
            tooltip: {
                isHtml: true,
                ignoreBounds: false
            }
        };


    }
}

function getDataFromSheet(URL, queryString, callback) {
    var query = new google.visualization.Query(URL);
    query.setQuery(queryString);
    query.send(gotResponse);

    function gotResponse(response) {
        if(response.isError()) {
            console.log(response.getReasons());
            alert('Error in query: ' + response.getMessage() + " " + response.getDetailedMessage());
            return;
        }
        if(response.hasWaring()) {
            console.log(response.getReasons());
            alert('Warning from query: ' + response.getMessage() + " " + response.getDetailedMessage());
            return;
        }

        callback(response);
    }
}