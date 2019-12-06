package servlets;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.ParticipantDao;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="participants", urlPatterns = {"/participants"})

public class AllParticipantsServlet extends HttpServlet {

    final String DB_NAME = "ThePetProjectDB";
    final String COLLECTION_NAME = "Participants";
    MongoClient mongoClient = new MongoClient();
    MongoDatabase mdb = mongoClient.getDatabase(DB_NAME);
    MongoCollection participants = mdb.getCollection(COLLECTION_NAME);

    ParticipantDao pdao = new ParticipantDao(participants);



    protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        List<Document> documentList = pdao.getAllParticipants();
        response.setStatus(HttpServletResponse.SC_OK);

        for(Document doc : documentList) {
            response.getWriter().println(doc.toJson());
        }
    }
}
