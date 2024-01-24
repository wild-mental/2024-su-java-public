package travelandimmigration;

import java.util.List;

interface ITravelProcessActions {
    void processGroupEntry(List<Person> travelers);
    void processImmigrantRequest(List<Person> immigrants);
}