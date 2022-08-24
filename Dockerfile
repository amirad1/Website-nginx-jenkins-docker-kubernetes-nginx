FROM nginx

RUN rm -rf /etc/nginx.conf

COPY /site /site

COPY /nginx /etc/nginx
