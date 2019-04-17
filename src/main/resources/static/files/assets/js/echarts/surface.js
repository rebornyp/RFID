function randomData(num) {
    now = new Date(+now + oneDay);
    value = num * 2 ;
    return {
        name: now.toString(),
        value: [
            [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
            Math.round(value)
        ]
    }
}

var data = [];
var now = new Date(2018, 7, 6);
var oneDay = 24 * 3600 * 1000;
var value = Math.random() * 1000;
for (var i = 0; i < 1; i++) {
    data.push(randomData(10));
    now = new Date(2018, 8, 2);
    data.push(randomData(6));
    now = new Date(2018, 8, 11);
    data.push(randomData(11));
    now = new Date(2019, 3, 11);
    data.push(randomData(20));
    now = new Date(2019, 3, 12);
    data.push(randomData(33));
}

option = {
    title: {
        text: '仓储监控出入库数历史纪录折线统计图'
    },
    tooltip: {
        trigger: 'axis',
        formatter: function (params) {
            params = params[0];
            var date = new Date(params.name);
            return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1];
        },
        axisPointer: {
            animation: false
        }
    },
    xAxis: {
        type: 'time',
        splitLine: {
            show: false
        }
    },
    yAxis: {
        type: 'value',
        boundaryGap: [0, '100%'],
        splitLine: {
            show: false
        }
    },
    series: [{
        name: '模拟数据',
        type: 'line',
        showSymbol: false,
        hoverAnimation: false,
        data: data
    }]
};

setInterval(function () {
    /*for (var i = 0; i < 5; i++) {
        data.shift();
        data.push(randomData(8));
    }*/
    myChart.setOption({
        series: [{
            data: data
        }]
    });
}, 1000);

//载入图表
$(function () {
    chartOutChar = echarts.init(document.getElementById('showChart'));
    chartOutChar.setOption(option);
});