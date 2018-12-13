package fr.laerce.cinema.web;

import fr.laerce.cinema.dao.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**On indique a springboot qu'il est un controller web on écrit cette phrase**/
@Controller
public class MainController {
    //on peut utiliser cette méthode avec autowired et component dans le servlet DataModel
    @Autowired
    DataModel dataModel;

    //Pour mapper la servlet,ça remplace ce que l'on met dans web.xml.
    @GetMapping("/")
    public String main(Model M) {
        //on ajoute a l'objet model la clef nom et jerome_gide
        M.addAttribute("annonce", "sur le site du Cineman");
        M.addAttribute("films", dataModel.getFilms());
        //on return la chaine string index de façon à ouvrir index.html
        return "index";
    }

    @GetMapping("/film")
        /**On céer notre modèle pour page film**/
        public String film(Model model){
            model.addAttribute("films", dataModel.getFilms());
            /** On retourne la chaine string film de façon à ouvrir**/
            return "film";
    }

    @GetMapping("/film/{id}")
    //on recupere id grace à pathvariable
    public String detail(Model m, @PathVariable("id") String id) {
        Integer idFilm = Integer.parseInt(id);
        m.addAttribute("film", dataModel.getById(idFilm));
        return "detail";
    }


    private String url;

    //deuxieme methode pour affichezr  image
    @GetMapping("/static/affiches/{id}")
    public void affiche(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) throws IOException {

        String filename = url + id;

        // ============ UTILITAIRE POUR IMPORTER DES IMAGES A PARTIR D'UN FOLDER EXTERNE A L'APPLICATION ============ //
        String mime = request.getServletContext().getMimeType(filename);
        if (mime == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        response.setContentType(mime);
        File file = new File(filename);
        response.setContentLength((int) file.length());
        FileInputStream in = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();
    }

            @GetMapping("/acteur/{id}")
            //on recupere id grace à pathvariable
            public String acteur (Model m, @PathVariable("id") String id){
                m.addAttribute("actor", dataModel.getByAf(id));
                return "acteur";
            }


}
