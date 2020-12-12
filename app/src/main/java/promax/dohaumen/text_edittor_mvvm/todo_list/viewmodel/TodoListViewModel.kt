package promax.dohaumen.text_edittor_mvvm.todo_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import promax.dohaumen.text_edittor_mvvm.todo_list.data.DataTodoListFragment
import promax.dohaumen.text_edittor_mvvm.todo_list.data.Task
import promax.dohaumen.text_edittor_mvvm.todo_list.data.TaskDatabase

class TodoListViewModel: ViewModel() {
    val tasks: LiveData<List<Task>> by lazy {
        TaskDatabase.get.dao().getLiveData(false)
    }
    val tasksCompleted: LiveData<List<Task>> by lazy {
        TaskDatabase.get.dao().getLiveData(true)
    }
    val allTasks: LiveData<List<Task>> by lazy {
        TaskDatabase.get.dao().getLiveData()
    }

    val isShowNumber: MutableLiveData<Boolean> by lazy {
        val isShow = DataTodoListFragment.isShowNumber()
        MutableLiveData(isShow)
    }

    fun saveData() {
        DataTodoListFragment.setShowNumber(isShowNumber.value!!)
    }







}