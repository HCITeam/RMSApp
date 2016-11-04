/**
 * Created by Lenovo on 2016/5/13.
 */
$(document).ready(function(){
    //score
    var repoScore = echarts.init(document.getElementById('repoScore'));
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
    repoScore.setOption(option);
//language
    var repoLan = echarts.init(document.getElementById('repoLan'));
    var option = {
        title : {
            text: '', subtext: '', x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {d}%"
        },
        legend: {
            orient: 'horizontal',
            left: 'left',
            data: lanName
        },
        series : [
            {
                name: 'Language',
                type: 'pie',
                radius : '60%',
                center: ['50%', '50%'],
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
    repoLan.setOption(option);
//Addition and Deletion
    var repoAD = echarts.init(document.getElementById('repoAD'));
    var option = {
        title: {text: ''},
        tooltip : {trigger: 'axis'},
        legend: {
            data:['Addition','Deletion']
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
                type : 'category',
                boundaryGap : false,
                data : adDate
            }
        ],
        yAxis : [{
            type : 'value'
        }],
        series : [
            {
                name:'Addition',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data : aData
            },
            {
                name:'Deletion',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data: dData
            }
        ]
    };
    repoAD.setOption(option);
//punch card
    var repoPC = echarts.init(document.getElementById('repoPC'));
    var hours = ['12a', '1a', '2a', '3a', '4a', '5a', '6a',
        '7a', '8a', '9a','10a','11a',
        '12p', '1p', '2p', '3p', '4p', '5p',
        '6p', '7p', '8p', '9p', '10p', '11p'];
    var days = ['Saturday', 'Friday', 'Thursday',
        'Wednesday', 'Tuesday', 'Monday', 'Sunday'];
    var data = punchData;
    data = data.map(function (item) {
        return [item[1], item[0], item[2]];
    });
    var option = {
        title: {
//		text: 'Punch Card of Github',
//		link: 'https://github.com/pissang/echarts-next/graphs/punch-card'
        },
        legend: {
            data: ['Punch Card'],
            left: 'right'
        },
        tooltip: {
            position: 'top',
            formatter: function (params) {
                return params.value[2] + ' commits in ' + hours[params.value[0]] + ' of ' + days[params.value[1]];
            }
        },
        grid: {
            left: 2,
            bottom: 10,
            right: 20,
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: hours,
            boundaryGap: false,
            splitLine: {
                show: true,
                lineStyle: {
                    color: '#ddd',
                    type: 'dashed'
                }
            },
            axisLine: {
                show: false
            }
        },
        yAxis: {
            type: 'category',
            data: days,
            axisLine: {
                show: false
            }
        },
        series: [{
            name: 'Punch Card',
            type: 'scatter',
            symbolSize: function (val) {
                return parseInt(Math.sqrt(12*val[2]));
            },
            data: data,
            animationDelay: function (idx) {
                return idx * 5;
            }
        }]
    };
    repoPC.setOption(option);
//different members' commit
//
//    alert(memName.length);
    //alert(memCDate);
    //alert(memCDate[0]);

    for(var i = 0;i < memName.length;i++){
        //var repoMemC = echarts.init(document.getElementById(memName[i]));
        //var option = {
        //    title: {
        //        text: ''
        //    },
        //    tooltip : {
        //        trigger: 'axis'
        //    },
        //    legend: {
        //        //data:['邮件营销']
        //    },
        //    toolbox: {
        //        feature: {
        //            saveAsImage: {}
        //        }
        //    },
        //    grid: {
        //        left: '3%',
        //        right: '4%',
        //        bottom: '3%',
        //        containLabel: true
        //    },
        //    xAxis : [
        //        {
        //            type : 'Date',
        //            boundaryGap : false,
        //            //data : memCDate[i]
        //            data:['2011','2012','2013']
        //        }
        //    ],
        //    yAxis : [
        //        {
        //            type : 'value'
        //        }
        //    ],
        //    series : [
        //        {
        //            name:'Commits',
        //            type:'line',
        //            stack: 'Number',
        //            areaStyle: {normal: {}},
        //            //data:memData[i]
        //            data:[12,32,12]
        //        }
        //    ]
        //}
        //repoMemC.setOption(option);
        var repoMemC = echarts.init(document.getElementById(memName[i]));
        option = {
            title: {
                text: memName[i]
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {},
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '8%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : memCDate[i]
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
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data:memData[i]
                }
            ]
        };
        repoMemC.setOption(option);
    }
});




