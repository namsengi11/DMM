# TaskGraph class that shows a graph with x and y axis.
# TaskGraph class takes in list of tasks and plots them on the graph.
# The tasks on the graph have to be clickable and when clicked, the task is highlighted.

import matplotlib.pyplot as plt

class TaskGraph:
    def __init__(self, tasks):
        self.fig, self.ax = plt.subplots()
        plt.rcParams['toolbar'] = 'None'  # Disable the navigation toolbar
        self.ax.set_xlim(-1, 11)
        self.ax.set_ylim(-1, 11)
        self.ax.axhline(y=5, color='k', linestyle='-')
        self.ax.axvline(x=5, color='k', linestyle='-')
        self.ax.set_xlabel('Importance')
        self.ax.set_ylabel('Urgency')
        self.ax.set_title('Decision Making Matrix')
        self.tasks = tasks
        self.task_points = {}  # Store plot objects for each task
        self.plot_tasks()
        self.fig.canvas.mpl_connect('button_press_event', self.on_click)
        self.fig.canvas.mpl_connect('motion_notify_event', self.on_mouse_move)
        self.closest_task = None

    def plot_tasks(self):
        for task in self.tasks:
            # Store the plot object for each task
            point, = self.ax.plot(task[0], task[1], 'ro')
            self.task_points[task] = point

    def on_click(self, event):
        if self.closest_task:
            print(f"Clicked on task: {self.closest_task}")

    # Monitor cursor position and highlight tasks when cursor is nearby
    def on_mouse_move(self, event):
        if event.inaxes is self.ax:
            # Reset all points to default style
            for point in self.task_points.values():
                point.set_markersize(6)
                point.set_markerfacecolor('red')

            self.closest_task = None
            # Check if cursor is near any task
            for task in self.tasks:
                if abs(task[0] - event.xdata) < 0.1 and abs(task[1] - event.ydata) < 0.1:
                    self.highlight_task(task)
                    self.closest_task = task

            self.fig.canvas.draw()

    def highlight_task(self, task):
        point = self.task_points[task]
        point.set_markersize(10)
        point.set_markerfacecolor('red')

if __name__ == "__main__":
    tasks = [(1, 2), (3, 4), (5, 6)]
    graph = TaskGraph(tasks)
    plt.show()
