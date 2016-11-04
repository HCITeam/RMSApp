/**
 * Created by Lenovo on 2016/5/13.
 */
$(document).ready(function(){
    var userCom = echarts.init(document.getElementById('userCom'));
    var option = {
        title : {text: '', subtext: '', x:'center'},
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {d}%"
        },
        legend: {
            orient: 'horizontal',
            bottom: 'top',
            data: comName
        },
        series : [
            {
                name: 'Company',
                type: 'pie',
                radius : '75%',
                center: ['50%', '40%'],
                data:comData,
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
    userCom.setOption(option);

    //userType
    var userType = echarts.init(document.getElementById('userType'));
    var option = {
        title : {text: '', subtext: '', x:'center'},
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {d}%"
        },
        legend: {
            orient: 'horizontal',
            bottom: 'top',
            data: typeName
        },
        series : [
            {
                name: 'Company',
                type: 'pie',
                radius : '75%',
                center: ['50%', '40%'],
                data:typeData,
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
    userType.setOption(option);

    //userRepo
    var userRepo = echarts.init(document.getElementById('userRepo'));
    var option = {
        title: {
            text: '',
            subtext: '',
            sublink: ''
        },
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            },
            formatter: function (params) {
                var tar;
                if (params[1].value != '-') {
                    tar = params[1];
                }
                else {
                    tar = params[0];
                }
                return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
            }
        },
        legend: {
            data:['repositories']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type : 'category',
            splitLine: {show:false},
            data :  repoNum
        },
        yAxis: {
            type : 'value'
        },
        series: [
            {
                name: '辅助',
                type: 'bar',
                stack: '总量',
                itemStyle: {
                    normal: {
                        barBorderColor: 'rgba(0,0,0,0)',
                        color: 'rgba(0,0,0,0)'
                    },
                    emphasis: {
                        barBorderColor: 'rgba(0,0,0,0)',
                        color: 'rgba(0,0,0,0)'
                    }
                }
            },
            {
                name: 'repositories',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'top'
                    }
                },
                data: repoData
            }
        ]
    };
    userRepo.setOption(option);

    var userGist = echarts.init(document.getElementById('userGist'));
    var option = {
        title: {
            text: '',
            subtext: '',
            sublink: ''
        },
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            },
            formatter: function (params) {
                var tar;
                if (params[1].value != '-') {
                    tar = params[1];
                }
                else {
                    tar = params[0];
                }
                return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
            }
        },
        legend: {
            data:['gists']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type : 'category',
            splitLine: {show:false},
            data :  gistNum
        },
        yAxis: {
            type : 'value'
        },
        series: [
            {
                name: '辅助',
                type: 'bar',
                stack: '总量',
                itemStyle: {
                    normal: {
                        barBorderColor: 'rgba(0,0,0,0)',
                        color: 'rgba(0,0,0,0)'
                    },
                    emphasis: {
                        barBorderColor: 'rgba(0,0,0,0)',
                        color: 'rgba(0,0,0,0)'
                    }
                }
            },
            {
                name: 'gists',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'top'
                    }
                },
                data: gistData
            }
        ]
    };
    userGist.setOption(option);

    var userFollower = echarts.init(document.getElementById('userFollower'));
    userFollower.setOption(option);

    var userFollowing = echarts.init(document.getElementById('userFollowing'));
    userFollowing.setOption(option);
});
