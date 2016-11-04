/**
 * Created by Lenovo on 2016/5/13.
 */
$(document).ready(function(){
    //score
    var userScore = echarts.init(document.getElementById('userScore'));
    var option = {
        title: {},
        tooltip: {},
        legend: {data: []},
        radar: {
            indicator:scoreIndicator
        },
        series: [{
            name: '',
            type: 'radar',
            data : [{
                value : scoreValue,
                name : 'Value'
            }]
        }]
    };
    userScore.setOption(option);
//language
    var userLan = echarts.init(document.getElementById('userLan'));
    var option = {
        title : {
            text: '', subtext: '', x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {d}%"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: lanName
        },
        series : [
            {
                name: 'Language',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data: lanData,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    userLan.setOption(option);
});
//contribution
    var userLan = echarts.init(document.getElementById('userContr'));
    var option = {
    title: {
        text: ''
    },
    tooltip: {},
    legend: {
        // data:['']
    },
    xAxis: {
        data: repoName
    },
    yAxis: {},
    series: [{
        name: 'Contribution',
        type: 'bar',
        data: contrData
    }]
};
    userLan.setOption(option);
//commit
    var userCommit = echarts.init(document.getElementById('userCommit'));
    var option = {
    title: {
        text: ''
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        //data:['邮件营销']
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'Date',
            boundaryGap : false,
            data : ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'Commits',
            type:'line',
            stack: 'Number',
            areaStyle: {normal: {}},
            data:commitData
        }
    ]
    }
    userCommit.setOption(option);