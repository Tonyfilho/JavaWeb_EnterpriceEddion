<%-- 
    Document   : P04_CicloDeVida.jsp
    Author     : TurtleLearning.com: José Aser
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<title>P04_CicloDeVida</title>
</head>
<body>
    <h1>Ciclo de vida</h1>
       <ol>
           <li>Depois de escrever este parágrafo na JSP faça RUN e confirme
               que fica visível no HTML assim como no source code da servlet
               que entretanto foi produzido;
           </li>
           <!-- 
           <li>Agora adicione este parágrafo e faça Save. Vá ao 
               browser e faça "refresh" (F5, CTRL-F5, CMD-r) confirmando que 
               as alterações estão a ser mostradas pelo servlet container;
           </li>
            -->
      </ol>
</body>
<!-- Execute esta servlet e confirme que é visível o primeiro parágrafo. O segundo parágrafo aparece como um comentário HTML e portanto só é visível com View Source.

Aceda ao source file e confirme o código Java que foi gerado. Em principio está na pasta:
/Users/myuser/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/work/Catalina/localhost/PaginasJSP/org/apache/jsp

Agora retire o comentário HTML sobre o segundo parágrafo da JSP. Grave a alteração. Em seguida vá ao browser e faça "refresh" (F5, CTRL-F5, CMD-SHIFT-R), confirmando que o segundo parágrafo já está visível.

Se consultar o ficheiro source da servlet vai confirmar que já contem as alterações, pois o Servlet Container já gerou a nova servlet.

No entanto, em algumas situações, como por exemplo no Netbeans com Tomcat em versões antigas, o novo ficheiro só é gerado após a operação de build. No nosso caso a nova versão aparece pouco depois da gravação, pois o Eclipse faz deploy da nova versão da JSP de forma quase instantânea. O Tomcat detecta a variação, 
gera novo Java, faz a compilação e produz novo ficheiro class. -->
</html>

