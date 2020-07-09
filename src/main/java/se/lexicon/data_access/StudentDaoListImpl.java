package se.lexicon.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao{

    private List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student student) {
        if(!students.contains(student)){
            students.add(student);
        }
        return student;
    }

    @Override
    public Student find(int id) {
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        throw new RuntimeException("Could not find student with id " + id);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) {
        Student toDelete = find(id);
        students.remove(toDelete);
    }
}
