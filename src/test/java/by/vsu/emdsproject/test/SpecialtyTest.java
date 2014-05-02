package by.vsu.emdsproject.test;

import by.vsu.emdsproject.dao.AbiturientDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/emds-web-context.xml"})
public class SpecialtyTest {

    static String[] data = new String[]{"Нагибин Рюрик Леонтиевич\n" +
            "Краснобаев Максим Александрович\n" +
            "Никаев Всеслав Сократович\n" +
            "Сафронов Поликарп Андронович\n" +
            "Хрустицкий Роман Мирославович\n" +
            "Горбачёв Иван Ростиславович\n" +
            "Арнаутов Андрей Касьянович\n" +
            "Чичканов Дементий Вячеславович\n" +
            "Федин Филипп Сергеевич\n" +
            "Рясной Никанор Венедиктович\n" +
            "Алиев Евгений Леонович\n" +
            "Оспищев Кирилл Назарович\n" +
            "Квакин Егор Андроникович\n" +
            "Моряков Афанасий Серафимович\n" +
            "Берлунов Андрей Казимирович\n" +
            "Сунгатулин Юрий Архипович\n" +
            "Рыбаков Авдей Святославович\n" +
            "Колтышев Мирослав Адамович\n" +
            "Юбкин Марк Иннокентиевич\n" +
            "Чемоданов Вячеслав  Пахомович",
            "Кучеров Семён Аникитевич\n" +
                    "Карасевич Андрей Давидович\n" +
                    "Думановский Феликс Дмитриевич\n" +
                    "Гершельман Ефим Святославович\n" +
                    "Зайков Степан Назарович\n" +
                    "Курицын Владислав Евлампиевич\n" +
                    "Федин Михаил Трофимович\n" +
                    "Енин Агап Игоревич\n" +
                    "Погодин Сергей Евстафиевич\n" +
                    "Маркелов Кирилл Титович\n" +
                    "Михальченков Андрей Родионович\n" +
                    "Калугер Ираклий Ростиславович\n" +
                    "Ячиков Соломон Серафимович\n" +
                    "Квартиров Лавр Ираклиевич\n" +
                    "Кузик Константин Ильевич\n" +
                    "Манин Юрий Егорович\n" +
                    "Танков Фадей Елизарович\n" +
                    "Жданов Кирилл Остапович\n" +
                    "Блаженов Вадим Наумович\n" +
                    "Фролов Михаил Кириллович",
            "Фоменков Максим Онисимович\n" +
                    "Яндарбиев Евгений Георгиевич\n" +
                    "Солодовников Николай Сергеевич\n" +
                    "Шалимов Игнатий Никифорович\n" +
                    "Майструк Никита Филимонович\n" +
                    "Колонтаев Денис Богданович\n" +
                    "Анасенко Аким Наумович\n" +
                    "Свистовский Роман Несторович\n" +
                    "Дудник Артём  Еремеевич\n" +
                    "Мирзoян Владлен Матвеевич\n" +
                    "Староволков Сергей Фомевич\n" +
                    "Ситников Егор Захарович\n" +
                    "Антипин Владилен Захарович\n" +
                    "Кашканов Вячеслав  Кириллович\n" +
                    "Кораблин Пимен Тарасович\n" +
                    "Слепцов Виктор Ипатиевич\n" +
                    "Шалаганов Виктор Олегович\n" +
                    "Каунайте Елизар Чеславович\n" +
                    "Сарычев Никита Владиславович\n" +
                    "Блохин Денис Ипатиевич",
            "Озеров Степан Ираклиевич\n" +
                    "Коровин Эрнст Назарович\n" +
                    "Шамов Модест Елисеевич\n" +
                    "Волобуев Богдан Владимирович\n" +
                    "Науменко Эдуард Михеевич\n" +
                    "Апраксин Кирилл Панкратиевич\n" +
                    "Амелин Яков Семенович\n" +
                    "Мичурин Артур Евграфович\n" +
                    "Курбанов Максим Игоревич\n" +
                    "Шелепов Трофим Богданович\n" +
                    "Шумилов Пимен Валерьянович\n" +
                    "Крутов Владислав Кондратович\n" +
                    "Юдин Илья Артемиевич\n" +
                    "Никоненко Николай Леонтиевич\n" +
                    "Панфилов Александр Измаилович\n" +
                    "Крюков Андрей Саввевич\n" +
                    "Зуб Порфирий Ульянович\n" +
                    "Пустов Георгий Трофимович\n" +
                    "Белевич Прокофий Ипатович\n" +
                    "Забабурин Игорь Панкратиевич",
            "Балакин Вадим Денисович\n" +
                    "Купцов Павел Ипатиевич\n" +
                    "Язин Степан Онисимович\n" +
                    "Болдырев Денис Семенович\n" +
                    "Болокан Пахом Брониславович\n" +
                    "Януть Викентий Климентович\n" +
                    "Галдин Сергей Яковович\n" +
                    "Танков Александр Адрианович\n" +
                    "Пичугин Артемий Брониславович\n" +
                    "Ямковой Владислав Чеславович\n" +
                    "Гремпель Онуфрий Изяславович\n" +
                    "Квартальнов Глеб Давыдович\n" +
                    "Курышин Нестор Сигизмундович\n" +
                    "Кобзев Михаил Вячеславович\n" +
                    "Менщиков Владислав Семенович\n" +
                    "Задорожный Нестор Назарович\n" +
                    "Илюшкин Роман Маркович\n" +
                    "Дорогов Измаил Арсениевич\n" +
                    "Эсце Прокл Эмилевич\n" +
                    "Серёгин Евгений Игнатиевич\n"
    };

    @Autowired
    AbiturientDAO dao;

    @Test
    public void writeReadTest() {
        String[] names = data[0].split("\n");
        for (String name : names) {
            DBObject student = new BasicDBObject();
            student.put("faculty", "Математический");
            String[] split = name.split(" ");
            student.put("firstName", split[0]);
            student.put("middleName", split[1]);
            student.put("lastName", split[2]);
            dao.insert(student);
        }
        names = data[1].split("\n");
        for (String name : names) {
            DBObject student = new BasicDBObject();
            student.put("faculty", "Физический");
            String[] split = name.split(" ");
            student.put("firstName", split[0]);
            student.put("middleName", split[1]);
            student.put("lastName", split[2]);
            dao.insert(student);
        }
        names = data[2].split("\n");
        for (String name : names) {
            DBObject student = new BasicDBObject();
            student.put("faculty", "Биологический");
            String[] split = name.split(" ");
            student.put("firstName", split[0]);
            student.put("middleName", split[1]);
            student.put("lastName", split[2]);
            dao.insert(student);
        }
        names = data[3].split("\n");
        for (String name : names) {
            DBObject student = new BasicDBObject();
            student.put("faculty", "Исторический");
            String[] split = name.split(" ");
            student.put("firstName", split[0]);
            student.put("middleName", split[1]);
            student.put("lastName", split[2]);
            dao.insert(student);
        }
        names = data[4].split("\n");
        for (String name : names) {
            DBObject student = new BasicDBObject();
            student.put("faculty", "Юридический");
            String[] split = name.split(" ");
            student.put("firstName", split[0]);
            student.put("middleName", split[1]);
            student.put("lastName", split[2]);
            dao.insert(student);
        }
    }

}
