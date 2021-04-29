环境准备

1. 安装`nodejs`

2. 安装`apidoc`

   ```shell
   npm install apidoc -g
   ```

   

在待生成API文档的项目更目录中新建`apidoc.json`文件

```json
{
	"name": "XXAPI文档",
	"version": "1.0.0",
	"description": "XXAPI文档描述",
	"title": "文档生成",
	"url": "http://127.0.0.1:666/api",
	"sampleUrl": "http://127.0.0.1:666/api"
}
```



命令行进入项目目录执行生成文档命令

```shell
apidoc -i 项目路径 -o API文档存放路径
```

> 例如：
>
> ```shell
> apidoc -i D:/SimpleCode/spring-boot-simple/spring-boot-doc-simple -o D:/dev/api-doc/html
> ```



使用Nginx代理解决跨域问题

1. 修改配置文件`nginx.conf`

   ```conf
   
   #user  nobody;
   worker_processes  1;
   
   #error_log  logs/error.log;
   #error_log  logs/error.log  notice;
   #error_log  logs/error.log  info;
   
   #pid        logs/nginx.pid;
   
   
   events {
       worker_connections  1024;
   }
   
   
   http {
       include       mime.types;
       default_type  application/octet-stream;
   
       #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
       #                  '$status $body_bytes_sent "$http_referer" '
       #                  '"$http_user_agent" "$http_x_forwarded_for"';
   
       #access_log  logs/access.log  main;
   
       sendfile        on;
       #tcp_nopush     on;
   
       #keepalive_timeout  0;
       keepalive_timeout  65;
   
       #gzip  on;
   
       server {
           listen       666;
           server_name  localhost;
           location / {
               root   html;
               index  index.html index.htm;
           }
   		
   		location /api/  {   
   			proxy_pass http://remoteAddr/;        #通过配置端口指向部署websocker的项目
   			proxy_http_version 1.1; 		 
   			proxy_set_header Upgrade $http_upgrade;    
   			proxy_set_header Connection "Upgrade";    
   			proxy_set_header X-real-ip $remote_addr;
   			proxy_set_header X-Forwarded-For $remote_addr;
   		}
   
           #error_page  404              /404.html;
   
           # redirect server error pages to the static page /50x.html
           #
           error_page   500 502 503 504  /50x.html;
           location = /50x.html {
               root   html;
           }
   
       }
   
   
   	upstream remoteAddr{
   		 server 192.168.0.78:8080;
       }
   
   }
   ```

   

2. 将刚刚生成的API文件全部放到`nginx`目录中的`html`中

3. 启动nginx

4. 访问 http://127.0.0.1:666





> apidoc 文档注释可使用IDEA 插件[apiDoc](https://plugins.jetbrains.com/plugin/11580-apidoc)进行编写文档注释
>
> 快捷键ctrl+shift+alt+p，若快捷键被占用，可选中方法名，鼠标右键可以看到一个标签为`apiDoc`

