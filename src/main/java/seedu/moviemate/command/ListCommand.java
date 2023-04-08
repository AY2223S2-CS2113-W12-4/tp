package seedu.moviemate.command;

import seedu.moviemate.storage.Storage;
import seedu.moviemate.movie.ToWatchList;
import seedu.moviemate.ui.Ui;
import seedu.moviemate.movie.WatchedList;

public class ListCommand implements Command {

    @Override
    public void execute(WatchedList watchedList, ToWatchList toWatchList, Ui ui, Storage storage) {
        // list the watched list
        Ui.showListMessage(watchedList);
    }
}
