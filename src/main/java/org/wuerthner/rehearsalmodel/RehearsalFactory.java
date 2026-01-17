package org.wuerthner.rehearsalmodel;

import org.wuerthner.rehearsalmodel.action.RehearsalActionProvider;
import org.wuerthner.rehearsalmodel.model.*;
import org.wuerthner.sport.api.*;
import org.wuerthner.sport.attribute.StaticListAttribute;
import org.wuerthner.sport.core.ModelClipboard;
import org.wuerthner.sport.core.ModelHistory;
import org.wuerthner.sport.util.PdfViewerExecutor;

import java.io.File;
import java.util.*;

public abstract class RehearsalFactory implements ModelElementFactory {
    private final static ActionProvider actionProvider = new RehearsalActionProvider();
    private final static History history = new ModelHistory();
    private final static Clipboard clipboard = new ModelClipboard();
    private final static PdfViewerExecutor pdfViewerExecutor = new PdfViewerExecutor();

    @Override
    public <T extends ModelElement> T createElement(String typeName) {
        T element;
        switch (typeName) {
            case Model.TYPE:
                element = (T) new Model();
                ((Model)element).setUserMap(getUserMap());
                break;
            case Project.TYPE:
                element = (T) new Project();
                break;
            case Appointment.TYPE:
                element = (T) new Appointment();
                break;
            case Cancellation.TYPE:
                element = (T) new Cancellation();
                break;
            case Location.TYPE:
                element = (T) new Location();
                break;
            case Work.TYPE:
                element = (T) new Work();
                break;
            case Voice.TYPE:
                element = (T) new Voice();
                ((Voice)element).setUserMap(getUserMap());
                break;
            default:
                throw new RuntimeException("Invalid element type: " + typeName);
        }
        return element;
    }

    @Override
    public List<ModelElement> createElementList(UserProvider userProvider) {
        Model model = new Model();
        model.setUserMap((userProvider.getUserMap()));
        Voice voice = new Voice();
        voice.setUserMap(userProvider.getUserMap());
        return Arrays.asList(new ModelElement[]{
            model, new Project(), new Appointment(), new Cancellation(), new Location(), new Work(), voice
        });
    }

    @Override
    public String getRootElementType() { return Model.TYPE; }

    @Override
    public ActionProvider getActionProvider() {
        return actionProvider;
    }

    @Override
    public Optional<History> getHistory() {
        return Optional.of(history);
    }

    @Override
    public Optional<Clipboard> getClipboard() {
        return Optional.of(clipboard);
    }

    @Override
    public Optional<Executor<File>> getPdfViewerExecutor() { return Optional.of(pdfViewerExecutor); }

    @Override
    public String getAppName() { return "Rehearsal"; }

    @Override
    public String getFileExtension() { return "rhsl"; }

}
