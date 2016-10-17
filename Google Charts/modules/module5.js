
// Load the Visualization API and the corechart package
google.charts.load('current', { 'packages': ['corechart', 'table'] });

google.charts.setOnLoadCallback(drawChart);


function drawChart() {

    var rawArray = [
        ['Aarddvarks', 12, 'Noctunal mammal native to Africa'],
        ['Badgers', 16, 'Eleven species, including <i>honey badger</i>'],
        ['Cougars', 22, 'Also known as the mountain lion, puma or panther'],
        ['Donkeys', 76, 'Used as a working animal for a least 5000 years'],
        ['Elephants', 7, 'Can weigh up to 15000 lb / 6800 kg']
    ];

    var data = google.visualization.arrayToDataTable(rawArray, true);

    data.setColumnProperty(2, 'role', 'tooltip');
    data.setColumnProperty(2, 'html', true);

    var options = {
        legend: 'none',
        width: 500,
        tooltip: { isHtml: true }
    };

    var chart = new google.visualization.ColumnChart(document.getElementById('divChart'));
    chart.draw(data, options);
}