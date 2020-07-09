package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.data_access.StudentDao;
import se.lexicon.exception.NotYetImplementedException;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.List;

@Service
public class StudentManagementConsoleImpl implements StudentManagement {

    private final StudentDao studentDao;
    private final UserInputService inputService;

    @Autowired
    public StudentManagementConsoleImpl(StudentDao studentDao, UserInputService inputService) {
        this.studentDao = studentDao;
        this.inputService = inputService;
    }

    @Override
    public Student create() {
        System.out.print("Input id: ");
        int id = inputService.getInt();
        System.out.print("Input your name: ");
        String name = inputService.getString();
        Student student = new Student(id, name);
        return save(student);

    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) throws RuntimeException {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student removed = studentDao.find(id);
        studentDao.delete(id);
        return removed;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        throw new NotYetImplementedException("This method is not implemented yet");
    }
}
