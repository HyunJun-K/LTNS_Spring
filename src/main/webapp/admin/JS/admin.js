/**
 * 
 */

var ctx = document.getElementById('mychart');

var mychart = new Chart(ctx, {

    type : 'bar',
    data : {
        labels : ["red", "blue" , "yellow", "Green", "Purple","Orange"],
        datasets:[{
            label : '# of votes',
            data : [12,19,3,5,2,3],
            backgroundColor : [
                'rgba(255,99,132, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)'
            ],
            borderWidth : 1
        }]
     
    },

    option : {
        scales : {
            yAxes:[{
                ticks : {
                    beginAtZero :true
                }
            }]
        }
    }

});