package helloword;

import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Speech {

	  @RequestMapping(value = "/audio/{msg}", method = RequestMethod.GET)
	  //A chamada principal vai ficar "localhost:8080/audio/(aqui você coloca a mensagem que quer ouvir)"
	  public ResponseEntity<Object> redirectToExternalUrl(@PathVariable("msg")String msg,HttpServletResponse response) throws Exception { 
	  //Essa url para a tradução do google Translate
	  URI uri = new URI("https://translate.google.com.br/translate_tts?ie=UTF-8&q=" + msg
	  +"&tl=pt&client=gtx"); HttpHeaders httpHeaders = new HttpHeaders();
	  httpHeaders.setLocation(uri); return new ResponseEntity<>(httpHeaders,
	  HttpStatus.SEE_OTHER); 
	  }

}
