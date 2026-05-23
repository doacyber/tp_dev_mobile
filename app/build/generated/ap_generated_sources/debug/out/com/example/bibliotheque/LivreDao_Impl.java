package com.example.bibliotheque;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LivreDao_Impl implements LivreDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Livre> __insertionAdapterOfLivre;

  private final EntityDeletionOrUpdateAdapter<Livre> __deletionAdapterOfLivre;

  private final EntityDeletionOrUpdateAdapter<Livre> __updateAdapterOfLivre;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public LivreDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLivre = new EntityInsertionAdapter<Livre>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `livres` (`id`,`titre`,`auteur`,`isbn`,`disponible`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Livre entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitre());
        }
        if (entity.getAuteur() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAuteur());
        }
        if (entity.getIsbn() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getIsbn());
        }
        final int _tmp = entity.isDisponible() ? 1 : 0;
        statement.bindLong(5, _tmp);
      }
    };
    this.__deletionAdapterOfLivre = new EntityDeletionOrUpdateAdapter<Livre>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `livres` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Livre entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfLivre = new EntityDeletionOrUpdateAdapter<Livre>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `livres` SET `id` = ?,`titre` = ?,`auteur` = ?,`isbn` = ?,`disponible` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Livre entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitre());
        }
        if (entity.getAuteur() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAuteur());
        }
        if (entity.getIsbn() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getIsbn());
        }
        final int _tmp = entity.isDisponible() ? 1 : 0;
        statement.bindLong(5, _tmp);
        statement.bindLong(6, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM livres";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Livre livre) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLivre.insert(livre);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Livre livre) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfLivre.handle(livre);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Livre livre) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfLivre.handle(livre);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<Livre> getAllLivres() {
    final String _sql = "SELECT * FROM livres ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitre = CursorUtil.getColumnIndexOrThrow(_cursor, "titre");
      final int _cursorIndexOfAuteur = CursorUtil.getColumnIndexOrThrow(_cursor, "auteur");
      final int _cursorIndexOfIsbn = CursorUtil.getColumnIndexOrThrow(_cursor, "isbn");
      final int _cursorIndexOfDisponible = CursorUtil.getColumnIndexOrThrow(_cursor, "disponible");
      final List<Livre> _result = new ArrayList<Livre>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Livre _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTitre;
        if (_cursor.isNull(_cursorIndexOfTitre)) {
          _tmpTitre = null;
        } else {
          _tmpTitre = _cursor.getString(_cursorIndexOfTitre);
        }
        final String _tmpAuteur;
        if (_cursor.isNull(_cursorIndexOfAuteur)) {
          _tmpAuteur = null;
        } else {
          _tmpAuteur = _cursor.getString(_cursorIndexOfAuteur);
        }
        final String _tmpIsbn;
        if (_cursor.isNull(_cursorIndexOfIsbn)) {
          _tmpIsbn = null;
        } else {
          _tmpIsbn = _cursor.getString(_cursorIndexOfIsbn);
        }
        final boolean _tmpDisponible;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfDisponible);
        _tmpDisponible = _tmp != 0;
        _item = new Livre(_tmpId,_tmpTitre,_tmpAuteur,_tmpIsbn,_tmpDisponible);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
