package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.OpinionNotFoundException;
import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionService <T extends IOpinions> extends PersistentAbstract {
    private final Reader reader;
    private final Writer writer;
    private final RandomValues randomValues;

    public OpinionService(Reader reader, Writer writer, RandomValues randomValues) {
        this.reader = reader;
        this.writer = writer;
        this.randomValues = randomValues;
    }

    public List getAllOpinions() {
            return reader.getList(Opinion.class);
    }

    public Opinion findById(long id) {
        return (Opinion) reader.getList(Opinion.class).stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .orElseThrow(()-> new OpinionNotFoundException("Not found Opinion with given id: " + id));
    }

    public void editOpinionById(long id, Opinion opinion) {
        Opinion opinionToEdit = (Opinion) reader.getObjectById(Opinion.class, id);
        opinionToEdit.setUserOpinion(opinion.getUserOpinion());
        opinionToEdit.setUserRate(opinion.getUserRate());
        opinionToEdit.setUser(opinion.getUser());
        writer.save(opinionToEdit);
    }

    public void removeOpinionById(long id) {
        writer.remove(findById(id));
    }

    public void addOpinion(Opinion opinion, T t) {
        writer.save(opinion);
        t.getOpinions().add(opinion.getId());
        setRate(opinion,t);
        writer.save((Persistent) t);
    }

    public void setRate(Opinion opinion, T t) {
        double rate = ((t.getOpinions().size()-1) * t.getRate() + opinion.getUserRate()) /(t.getOpinions().size());
        rate *= 10;
        rate =  Math.round(rate)/10;
        t.setRate(rate);
    }


    public List randomOpinions(int numberOfOpinions, List opinionsListByObject){
        List outputList = randomValues.outputList(numberOfOpinions, opinionsListByObject);
        return outputList;
    }

    public Opinion getRandomOpinion(T t) {
        long opinionId= (long) randomOpinions(1, t.getOpinions()).get(0);
        return findById(opinionId);
    }
}

