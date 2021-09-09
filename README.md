# Liferay Widget Monitoring

If you're wondering how long your individual applications (widgets only currently) take to render,
this plugin will provide the answer directly below the actual application (use only in nonproduction
environments, or utilize CSS to hide it

    .stopwatch { 
        display:none;
    }

You can also find the output after each page load in the logs, if you set the log level for 
`com.liferay.sales.monitoring.filter` to `INFO`.

![illustration of the render time display](readme.png)

## Built & Tested on

* DXP 7.3 FP2 

## To Do

* Extend to be useful with fragment rendering too