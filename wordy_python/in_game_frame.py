#! /usr/bin/env python3
#  -*- coding: utf-8 -*-
#
# GUI module generated by PAGE version 7.6
#  in conjunction with Tcl version 8.6
#    May 20, 2023 05:27:54 PM CST  platform: Windows NT

import sys
import tkinter as tk
import tkinter.ttk as ttk
from tkinter import messagebox as mb
from tkinter.constants import *
import os.path

import in_game_frame_support
from wordy_idl import *

_script = sys.argv[0]
_location = os.path.dirname(_script)


_bgcolor = '#d9d9d9'  # X11 color: 'gray85'
_fgcolor = '#000000'  # X11 color: 'black'
_compcolor = 'gray40' # X11 color: #666666
_ana1color = '#c3c3c3' # Closest X11 color: 'gray76'
_ana2color = 'beige' # X11 color: #f5f5dc
_tabfg1 = 'black' 
_tabfg2 = 'black' 
_tabbg1 = 'grey75' 
_tabbg2 = 'grey89' 
_bgmode = 'light' 

_style_code_ran = 0
def _style_code():
    global _style_code_ran
    if _style_code_ran:
       return
    style = ttk.Style()
    if sys.platform == "win32":
       style.theme_use('winnative')
    style.configure('.',background=_bgcolor)
    style.configure('.',foreground=_fgcolor)
    style.configure('.',font='TkDefaultFont')
    style.map('.',background =
       [('selected', _compcolor), ('active',_ana2color)])
    if _bgmode == 'dark':
       style.map('.',foreground =
         [('selected', 'white'), ('active','white')])
    else:
       style.map('.',foreground =
         [('selected', 'black'), ('active','black')])
    style.configure('Vertical.TScrollbar',  background=_bgcolor,
        arrowcolor= _fgcolor)
    style.configure('Horizontal.TScrollbar',  background=_bgcolor,
        arrowcolor= _fgcolor)
    _style_code_ran = 1

class Toplevel1:

    def set_button_status(self, status):
        if status:
            self.submit_button.configure(state="enabled")
        else:
            self.submit_button.configure(state="disabled")

    def update_random_letters(self, random_letters):
        text = ""
        for letter in random_letters:
            text += f" {letter}"
        self.random_letters_label.configure(text=text)

    def update_feedback_label_text(self, text):
        self.Label1.configure(text=text)

    def update_round_time(self, time):
        self.round_time_label.configure(text=f"Round time: {time}")

    def add_word_to_list(self, word):
        self.submitted_words_listbox.insert(tk.END, word)

    def submit_button_functionality(self):
        try:
            if self.word_entry.get() == "":
                self.update_feedback_label_text("You must input a word first.")
            else:
                self.game_servant.submitWord(self.player_id, self.word_entry.get())
                self.update_feedback_label_text(f"{self.word_entry.get()} accepted")
                self.add_word_to_list(self.word_entry.get())
        except InvalidWordException:
            self.update_feedback_label_text("Non-existant word")
        except WordLengthException:
            self.update_feedback_label_text("Your word is too long")
        except WrongLetterException:
            self.update_feedback_label_text("Invalid letters used")


    def implement_components(self):
        self.submit_button.configure(command=self.submit_button_functionality)



    def __init__(self, top=None, game_servant=None, player_id=None):
        '''This class configures and populates the toplevel window.
           top is the toplevel containing window.'''

        top.geometry("600x450+500+144")
        top.minsize(120, 1)
        top.maxsize(1540, 845)
        top.resizable(1,  1)
        top.title("Wordy Game")
        top.configure(background="#d9d9d9")

        self.top = top
        self.game_servant = game_servant
        self.player_id = player_id

        self.Frame1 = tk.Frame(self.top)
        self.Frame1.place(relx=0.033, rely=0.178, relheight=0.789
                , relwidth=0.442)
        self.Frame1.configure(relief='groove')
        self.Frame1.configure(borderwidth="2")
        self.Frame1.configure(relief="groove")
        self.Frame1.configure(background="#d9d9d9")
        self.your_letters_are_label = tk.Label(self.Frame1)
        self.your_letters_are_label.place(relx=0.049, rely=0.039, height=29
                , width=142)
        self.your_letters_are_label.configure(anchor='w')
        self.your_letters_are_label.configure(background="#d9d9d9")
        self.your_letters_are_label.configure(compound='left')
        self.your_letters_are_label.configure(disabledforeground="#a3a3a3")
        self.your_letters_are_label.configure(foreground="#000000")
        self.your_letters_are_label.configure(text='''Your letters are:''')
        self.random_letters_label = tk.Label(self.Frame1)
        self.random_letters_label.place(relx=0.049, rely=0.158, height=35
                , width=238)
        self.random_letters_label.configure(anchor='w')
        self.random_letters_label.configure(background="#d9d9d9")
        self.random_letters_label.configure(compound='left')
        self.random_letters_label.configure(disabledforeground="#a3a3a3")
        self.random_letters_label.configure(foreground="#000000")
        self.random_letters_label.configure(text='''No letters yet''')
        self.word_entry = tk.Entry(self.Frame1)
        self.word_entry.place(relx=0.098, rely=0.313, height=30, relwidth=0.619)
        self.word_entry.configure(background="white")
        self.word_entry.configure(disabledforeground="#a3a3a3")
        self.word_entry.configure(font="TkFixedFont")
        self.word_entry.configure(foreground="#000000")
        self.word_entry.configure(insertbackground="black")
        _style_code()
        self.submit_button = ttk.Button(self.Frame1)
        self.submit_button.place(relx=0.098, rely=0.47, height=25, width=166)
        self.submit_button.configure(takefocus="")
        self.submit_button.configure(text='''Submit''')
        self.submit_button.configure(compound='left')
        self.Label1 = tk.Label(self.Frame1)
        self.Label1.place(relx=0.075, rely=0.648, height=31, width=214)
        self.Label1.configure(anchor='w')
        self.Label1.configure(background="#d9d9d9")
        self.Label1.configure(compound='left')
        self.Label1.configure(disabledforeground="#a3a3a3")
        self.Label1.configure(foreground="#000000")
        self.Label1.configure(text='''No feedback yet''')
        self.submitted_words_listbox = ScrolledListBox(self.top)
        self.submitted_words_listbox.place(relx=0.55, rely=0.178, relheight=0.789
                , relwidth=0.352)
        self.submitted_words_listbox.configure(background="white")
        self.submitted_words_listbox.configure(cursor="xterm")
        self.submitted_words_listbox.configure(disabledforeground="#a3a3a3")
        self.submitted_words_listbox.configure(font="TkFixedFont")
        self.submitted_words_listbox.configure(foreground="black")
        self.submitted_words_listbox.configure(highlightbackground="#d9d9d9")
        self.submitted_words_listbox.configure(highlightcolor="#d9d9d9")
        self.submitted_words_listbox.configure(selectbackground="#c4c4c4")
        self.submitted_words_listbox.configure(selectforeground="black")
        self.round_time_label = tk.Label(self.top)
        self.round_time_label.place(relx=0.033, rely=0.067, height=21, width=154)

        self.round_time_label.configure(activebackground="#f9f9f9")
        self.round_time_label.configure(anchor='w')
        self.round_time_label.configure(background="#d9d9d9")
        self.round_time_label.configure(compound='left')
        self.round_time_label.configure(disabledforeground="#a3a3a3")
        self.round_time_label.configure(foreground="#000000")
        self.round_time_label.configure(highlightbackground="#d9d9d9")
        self.round_time_label.configure(highlightcolor="black")
        self.round_time_label.configure(text='''Round Time Computing...''')
        self.your_submitted_words_label = tk.Label(self.top)
        self.your_submitted_words_label.place(relx=0.55, rely=0.067, height=31
                , width=124)
        self.your_submitted_words_label.configure(anchor='w')
        self.your_submitted_words_label.configure(background="#d9d9d9")
        self.your_submitted_words_label.configure(compound='left')
        self.your_submitted_words_label.configure(disabledforeground="#a3a3a3")
        self.your_submitted_words_label.configure(foreground="#000000")
        self.your_submitted_words_label.configure(text='''Your submitted words:''')
        self.implement_components()

# The following code is added to facilitate the Scrolled widgets you specified.
class AutoScroll(object):
    '''Configure the scrollbars for a widget.'''
    def __init__(self, master):
        #  Rozen. Added the try-except clauses so that this class
        #  could be used for scrolled entry widget for which vertical
        #  scrolling is not supported. 5/7/14.
        try:
            vsb = ttk.Scrollbar(master, orient='vertical', command=self.yview)
        except:
            pass
        hsb = ttk.Scrollbar(master, orient='horizontal', command=self.xview)
        try:
            self.configure(yscrollcommand=self._autoscroll(vsb))
        except:
            pass
        self.configure(xscrollcommand=self._autoscroll(hsb))
        self.grid(column=0, row=0, sticky='nsew')
        try:
            vsb.grid(column=1, row=0, sticky='ns')
        except:
            pass
        hsb.grid(column=0, row=1, sticky='ew')
        master.grid_columnconfigure(0, weight=1)
        master.grid_rowconfigure(0, weight=1)
        # Copy geometry methods of master  (taken from ScrolledText.py)
        methods = tk.Pack.__dict__.keys() | tk.Grid.__dict__.keys() \
                  | tk.Place.__dict__.keys()
        for meth in methods:
            if meth[0] != '_' and meth not in ('config', 'configure'):
                setattr(self, meth, getattr(master, meth))

    @staticmethod
    def _autoscroll(sbar):
        '''Hide and show scrollbar as needed.'''
        def wrapped(first, last):
            first, last = float(first), float(last)
            if first <= 0 and last >= 1:
                sbar.grid_remove()
            else:
                sbar.grid()
            sbar.set(first, last)
        return wrapped

    def __str__(self):
        return str(self.master)

def _create_container(func):
    '''Creates a ttk Frame with a given master, and use this new frame to
    place the scrollbars and the widget.'''
    def wrapped(cls, master, **kw):
        container = ttk.Frame(master)
        container.bind('<Enter>', lambda e: _bound_to_mousewheel(e, container))
        container.bind('<Leave>', lambda e: _unbound_to_mousewheel(e, container))
        return func(cls, container, **kw)
    return wrapped

class ScrolledListBox(AutoScroll, tk.Listbox):
    '''A standard Tkinter Listbox widget with scrollbars that will
    automatically show/hide as needed.'''
    @_create_container
    def __init__(self, master, **kw):
        tk.Listbox.__init__(self, master, **kw)
        AutoScroll.__init__(self, master)
    def size_(self):
        sz = tk.Listbox.size(self)
        return sz

import platform
def _bound_to_mousewheel(event, widget):
    child = widget.winfo_children()[0]
    if platform.system() == 'Windows' or platform.system() == 'Darwin':
        child.bind_all('<MouseWheel>', lambda e: _on_mousewheel(e, child))
        child.bind_all('<Shift-MouseWheel>', lambda e: _on_shiftmouse(e, child))
    else:
        child.bind_all('<Button-4>', lambda e: _on_mousewheel(e, child))
        child.bind_all('<Button-5>', lambda e: _on_mousewheel(e, child))
        child.bind_all('<Shift-Button-4>', lambda e: _on_shiftmouse(e, child))
        child.bind_all('<Shift-Button-5>', lambda e: _on_shiftmouse(e, child))

def _unbound_to_mousewheel(event, widget):
    if platform.system() == 'Windows' or platform.system() == 'Darwin':
        widget.unbind_all('<MouseWheel>')
        widget.unbind_all('<Shift-MouseWheel>')
    else:
        widget.unbind_all('<Button-4>')
        widget.unbind_all('<Button-5>')
        widget.unbind_all('<Shift-Button-4>')
        widget.unbind_all('<Shift-Button-5>')

def _on_mousewheel(event, widget):
    if platform.system() == 'Windows':
        widget.yview_scroll(-1*int(event.delta/120),'units')
    elif platform.system() == 'Darwin':
        widget.yview_scroll(-1*int(event.delta),'units')
    else:
        if event.num == 4:
            widget.yview_scroll(-1, 'units')
        elif event.num == 5:
            widget.yview_scroll(1, 'units')

def _on_shiftmouse(event, widget):
    if platform.system() == 'Windows':
        widget.xview_scroll(-1*int(event.delta/120), 'units')
    elif platform.system() == 'Darwin':
        widget.xview_scroll(-1*int(event.delta), 'units')
    else:
        if event.num == 4:
            widget.xview_scroll(-1, 'units')
        elif event.num == 5:
            widget.xview_scroll(1, 'units')
def start_up():
    in_game_frame_support.main()

if __name__ == '__main__':
    in_game_frame_support.main()




