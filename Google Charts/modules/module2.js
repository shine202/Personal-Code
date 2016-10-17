

// Load the Visualization API and the corechart package
google.charts.load('current', { 'packages': ['corechart'] });

// Set a callback to run when the Google Visualization API is loaded
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

    var dataTableBadFormat = getRawData();

    var convertedData = prepareDataTableForPieChart(dataTableBadFormat);

    var options = {
        title: 'Number of Animals Spotted',
        pieSliceText: 'percentage',
        legend: { position: 'top', maxLines: 3 },
        height: 550
    };

    var chart = new google.visualization.PieChart(document.getElementById('divChart'));
    chart.draw(convertedData, options);
}

function prepareDataTableForPieChart(data) {

    var finalData = new google.visualization.DataTable();

    finalData.addColumn('string');
    finalData.addColumn('number');

    var numSrcColumns = data.getNumberOfColumns();
    finalData.addRows(numSrcColumns);

    for(var i = 0; i < numSrcColumns; i++) {
        var label = data.getValue(0, i);
        var value = data.getValue(1, i);

        finalData.setValue(i, 0, label);
        finalData.setValue(i, 1, value)
    }

    return finalData;
}

function getRawData() {

    var badJSarray = [
        ['Aarddvarks', 'Badgers', 'Cougars', 'Donkeys', 'Elephants'],
        [12, 16, 22, 102, 2]
    ];

    return google.visualization.arrayToDataTable(badJSarray, true);
}